package co.manager.rest;

import co.manager.ejb.ManagerApplicationBean;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author jguisao
 */
@ApplicationPath("res")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ManagerApplicationBean.class);
        resources.add(SessionREST.class);
        resources.add(SessionPoolREST.class);
        resources.add(HealthchekREST.class);
        resources.add(EventREST.class);
        resources.add(SondaREST.class);
        resources.add(PedBoxREST.class);
        resources.add(ReportREST.class);
        resources.add(TicketREST.class);
        resources.add(MotorepuestoREST.class);
    }
}