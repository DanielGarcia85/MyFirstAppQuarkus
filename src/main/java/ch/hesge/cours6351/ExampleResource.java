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
        int number = 17; // Exemple de nombre à tester
        boolean isPrime = isPrime(number);
        String result = "Hello RESTEasy. This is my first Quarkus App ! "
                + "Le nombre " + number + (isPrime ? " est un nombre premier." : " n'est pas un nombre premier.");
        Log.info(result);
        return result;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("bonjour")
    public String bonjour() {
        Log.info("test du log bonjour");
        Log.debug("debug message");
        return "Bonjour RESTEasy. This is my first Quarkus App !!!";
    }

    /**
     * Vérifie si un nombre est premier.
     * @param number Nombre à tester
     * @return true si le nombre est premier, false sinon
     */
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
