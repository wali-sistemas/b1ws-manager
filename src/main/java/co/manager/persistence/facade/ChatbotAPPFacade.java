package co.manager.persistence.facade;

import co.manager.persistence.entity.ChatbotAPP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ChatbotAPPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ChatbotAPPFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(ChatbotAPP entity, String companyName, boolean testing) {
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(entity);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del chatbot: " + entity, e);
            throw e;
        }
    }

    public ChatbotAPP find(Integer id, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(ChatbotAPP.class, id);
    }
}