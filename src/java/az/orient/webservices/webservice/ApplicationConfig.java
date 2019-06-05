package az.orient.webservices.webservice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {
@Override
public Set<Class<?>>getClasses(){
    return new HashSet<Class<?>>(Arrays.asList(WebServices.class));
}
}