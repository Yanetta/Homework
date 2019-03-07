package bookcontroller;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import controller.Library;
import org.glassfish.jersey.server.mvc.Viewable;


@Path("/libr")
public class BookController {
    private Library library = Library.libraryExampleCreator();

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Viewable libr(@QueryParam("id") String groupId) {

        if (groupId != null && groupId.equals("" + library.getId())) {
            return new Viewable("/librar", library);
        }
        return new Viewable("/libr");
    }
}
