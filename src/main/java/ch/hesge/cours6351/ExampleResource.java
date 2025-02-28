package ch.hesge.cours6351;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello() {
        Log.info("test du log hello");
        return "Hello RESTEasy. This is my first Quarkus App !";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("bonjour")
    public String bonjour() {
        Log.info("test du log bonjour");
        Log.debug("debug message");
        return "Bonjour RESTEasy. This is my first Quarkus App !!!";
    }
}
