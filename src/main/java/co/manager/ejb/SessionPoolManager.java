package co.manager.ejb;

import co.manager.dto.B1WSSession;
import co.manager.dto.SessionStatusDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author dbotero
 */
@ApplicationScoped
@Named("sessionPoolManager")
public class SessionPoolManager implements Serializable {
    private static final Logger CONSOLE = Logger.getLogger(SessionPoolManager.class.getSimpleName());

    private ConcurrentHashMap<String, LinkedBlockingQueue<B1WSSession>> availableSessions = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, B1WSSession> borrowedSessions = new ConcurrentHashMap<>();
    private int maxOpenSessions;
    private long sessionMaxAge;
    @EJB
    private SessionManager sessionManager;
    @EJB
    private StateManager stateManager;
    @Inject
    private ManagerApplicationBean appBean;

    @PostConstruct
    private void initialize() {
        maxOpenSessions = Integer.parseInt(appBean.obtenerValorPropiedad("manager.b1ws.maxOpenSessions"));
        sessionMaxAge = Long.parseLong(appBean.obtenerValorPropiedad("manager.b1ws.sessionMaxAge"));
    }

    public SessionPoolManager() {
    }

    public String getSession(String companyName) {
        CONSOLE.log(Level.INFO, "Solicitud de sesion para empresa {0}", companyName);
        B1WSSession session = null;
        if (availableSessions.containsKey(companyName)) {
            session = availableSessions.get(companyName).poll();
            if (session != null && session.getTimesBorrowed() % 10 == 0) {
                //Validar que la sesion se encuentre activa antes de retornarla
                session.setSessionId(validateSession(session.getSessionId(), companyName));
            }
        }
        if (session == null) {
            CONSOLE.log(Level.INFO, "No hay sesiones activas. Validando si se pueden iniciar nuevas");
            //si no hay elementos en la lista de sesiones disponibles, valida si estan todos en el mapa de sesiones
            //prestadas. si el numero de elementos prestados < que el numero maximo de sesiones, crea una nueva sesion,
            //la agrega al mapa de sesiones prestadas y la retorna
            if (borrowedSessions.size() < maxOpenSessions) {
                //abrir una nueva sesion
                String sessionId = sessionManager.login(companyName);
                if (sessionId == null) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                    return null;
                }
                CONSOLE.log(Level.INFO, "Se creo una nueva sesion con id {0}", sessionId);

                session = new B1WSSession();
                session.setCreated(System.currentTimeMillis());
                session.setSessionId(sessionId);
                session.setCompany(companyName);
            } else {
                CONSOLE.log(Level.SEVERE, "No es posible iniciar nuevas sesiones porque se ha alcanzado el limite de {0}.", maxOpenSessions);
                //no se pueden abrir mas sesiones, TODO: retornar error?
                return null;
            }
        }

        CONSOLE.log(Level.INFO, "Entregando sesion {0} al usuario", session.getSessionId());
        session.setLastBorrowed(System.currentTimeMillis());
        session.setTimesBorrowed(session.getTimesBorrowed() + 1);

        borrowedSessions.put(session.getSessionId(), session);
        logSessionStatus();
        return session.getSessionId();
    }

    public void returnSession(String sessionId) {
        CONSOLE.log(Level.INFO, "Recibiendo sesion {0} del usuario", sessionId);
        // Obtiene la sesion asociada con el id recibido y la elimina del mapa de sesiones prestadas
        B1WSSession borrowedSession = borrowedSessions.remove(sessionId);
        if (borrowedSession == null) {
            CONSOLE.log(Level.WARNING, "La sesion {0} no se encontro en el mapa de sesiones prestadas. Intentando cerrarla", sessionId);
            //si la sesion no se encuentra en el mapa, puede significar que el usuario la tenia asignada desde antes de
            //un reinicio del servicio. se procede a intentar cerrar la sesion en SAP y no se vuelve a agregar a la lista
            //de sesiones disponibles
            sessionManager.logout(sessionId);
            return;
        }

        // si la sesion si se encuentra en el mapa de sesiones prestadas, valida cuando fue creada
        long current = System.currentTimeMillis();
        if (current - borrowedSession.getCreated() > sessionMaxAge) {
            CONSOLE.log(Level.INFO, "La sesion {0} ha cumplido el tiempo maximo de vida y sera cerrada", sessionId);
            // si el tiempo desde que fue creada la sesion supera 3 horas, la cierra y no vuelve a agregarla a
            // la lista de disponibles
            sessionManager.logout(sessionId);
        } else {
            CONSOLE.log(Level.INFO, "La sesion {0} ha sido devuelta a la lista de sesiones disponibles", sessionId);
            // si el tiempo es inferior, la agrega a la lista de disponibles, en el ultimo lugar
            try {
                if (availableSessions.containsKey(borrowedSession.getCompany())) {
                    availableSessions.get(borrowedSession.getCompany()).put(borrowedSession);
                } else {
                    LinkedBlockingQueue<B1WSSession> sessions = new LinkedBlockingQueue<>();
                    sessions.put(borrowedSession);
                    availableSessions.put(borrowedSession.getCompany(), sessions);
                }
            } catch (InterruptedException e) {
                CONSOLE.log(Level.WARNING, "Ocurrio un error al devolver la sesion (" + borrowedSession + ") a la lista de disponibles. ", e);
            }
        }
        logSessionStatus();
    }

    private String validateSession(String sessionId, String companyName) {
        if (sessionId != null && !sessionId.isEmpty() && companyName != null && !companyName.isEmpty()) {
            CONSOLE.log(Level.INFO, "Validando si la sesion {0} se encuentra activa en el Di Server", sessionId);
            Response res = stateManager.getState(sessionId);
            if (res == null) {
                return getSession(companyName);
            }
        }
        return sessionId;
    }

    private void logSessionStatus() {
        int totalAvailable = 0;
        for (String key : availableSessions.keySet()) {
            totalAvailable += availableSessions.get(key).size();
        }
        CONSOLE.log(Level.INFO, "{0} sesiones prestadas, {1} sesiones disponibles",
                new Object[]{borrowedSessions.size(), totalAvailable});
    }

    public SessionStatusDTO reportStatus() {
        SessionStatusDTO status = new SessionStatusDTO();
        status.setAvailableSessions(availableSessions);
        status.setBorrowedSessions(borrowedSessions);
        return status;
    }

    public void resetSesion() {
        availableSessions = new ConcurrentHashMap<>();
        borrowedSessions = new ConcurrentHashMap<>();
    }
}