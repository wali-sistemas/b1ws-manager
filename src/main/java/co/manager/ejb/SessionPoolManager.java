package co.manager.ejb;

import co.manager.dto.B1WSSession;
import co.manager.dto.SessionDTO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
@Named("sessionPoolManager")
public class SessionPoolManager implements Serializable {
    private static final Logger CONSOLE = Logger.getLogger(SessionPoolManager.class.getSimpleName());

    private HashMap<String, LinkedList<B1WSSession>> availableSessions = new HashMap<>();
    private HashMap<String, B1WSSession> borrowedSessions = new HashMap<>();
    private int maxOpenSessions;
    private long sessionMaxAge;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        addListSession("VARROCPruebas");
    }

    public SessionPoolManager() {
        //TODO: inicializar las variables desde properties
        maxOpenSessions = 10;
        //3 horas, 60 minutos por hora, 60 segundos por minuto, 1000 milisegundos por segundo
        sessionMaxAge = 3 * 60 * 60 * 1000;
    }

    public String getSession(String companyName) {
        CONSOLE.log(Level.INFO, "Solicitud de sesion para empresa {0}", companyName);
        B1WSSession session = availableSessions.get(companyName).pollFirst();
        if (session == null) {
            CONSOLE.log(Level.INFO, "No hay sesiones activas. Validando si se pueden iniciar nuevas");
            //si no hay elementos en la lista de sesiones disponibles, valida si estan todos en el mapa de sesiones
            //prestadas. si el numero de elementos prestados < que el numero maximo de sesiones, crea una nueva sesion,
            //la agrega al mapa de sesiones prestadas y la retorna
            if (borrowedSessions.size() < maxOpenSessions) {
                //abrir una nueva sesion
                String sessionId = sessionManager.login(companyName);
                CONSOLE.log(Level.INFO, "Se creo una nueva sesion con id {0}", sessionId);

                session = new B1WSSession();
                session.setCreated(System.currentTimeMillis());
                session.setSessionId(sessionId);

                LinkedList<B1WSSession> list = new LinkedList<>();
                list.add(session);
                availableSessions.put(companyName, list);
            } else {
                CONSOLE.log(Level.SEVERE, "No es posible iniciar nuevas sesiones porque se ha alcanzado el limite de {0}.", maxOpenSessions);
                //no se pueden abrir mas sesiones, TODO: retornar error?
                return null;
            }
        }

        CONSOLE.log(Level.INFO, "Retornando sesion {0}", session.getSessionId());
        session.setLastBorrowed(System.currentTimeMillis());

        borrowedSessions.put(session.getSessionId(), session);
        logSessionStatus();
        return session.getSessionId();
    }

    public void returnSession(SessionDTO dto) {
        CONSOLE.log(Level.INFO, "Retornando sesion {0}", dto.getSessionID());
        // Obtiene la sesion asociada con el id recibido y la elimina del mapa de sesiones prestadas
        B1WSSession borrowedSession = borrowedSessions.remove(dto.getSessionID());

        if (borrowedSession == null) {
            CONSOLE.log(Level.WARNING, "La sesion {0} no se encontro en el mapa de sesiones prestadas. Intentando cerrarla", dto.getSessionID());
            //si la sesion no se encuentra en el mapa, puede significar que el usuario la tenia asignada desde antes de
            //un reinicio del servicio. se procede a intentar cerrar la sesion en SAP y no se vuelve a agregar a la lista
            //de sesiones disponibles
            sessionManager.logout(dto.getSessionID());
            return;
        }

        // si la sesion si se encuentra en el mapa de sesiones prestadas, valida cuando fue creada
        long current = System.currentTimeMillis();
        if (current - borrowedSession.getCreated() > sessionMaxAge || dto.isClosedID()) {
            CONSOLE.log(Level.INFO, "La sesion {0} ha cumplido el tiempo maximo de vida y sera cerrada", dto.getSessionID());
            // si el tiempo desde que fue creada la sesion supera 3 horas, la cierra y no vuelve a agregarla a
            // la lista de disponibles
            sessionManager.logout(dto.getSessionID());
        } else {
            CONSOLE.log(Level.INFO, "La sesion {0} ha sido devuelta a la lista de sesiones disponibles", dto.getSessionID());
            // si el tiempo es inferior, la agrega a la lista de disponibles, en el ultimo lugar
            //availableSessions.addLast(borrowedSession);
            availableSessions.get(0).addLast(borrowedSession);
        }
        logSessionStatus();
    }

    private void addListSession(String companyName) {
        if (availableSessions.size() <= 0) {
            LinkedList<B1WSSession> session = new LinkedList<>();
            for (int i = 0; i < 5; i++) {
                String sessionId = sessionManager.login(companyName);
                session.add(new B1WSSession(sessionId, System.currentTimeMillis()));
            }
            availableSessions.put(companyName, session);
        } else {
            return;
        }
    }

    private void logSessionStatus() {
        CONSOLE.log(Level.INFO, "{0} sesiones prestadas, {1} sesiones disponibles",
                new Object[]{borrowedSessions.size(), availableSessions.size()});
    }
}