package controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/rs/library/{libId}")
public class Controller {

    private static Map<Integer, Library> libraryMap = Arrays.asList(Library.libraryExampleCreator()).stream()
            .collect(Collectors.toMap(Library::getId, Function.identity()));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLibrary(@PathParam("libId") int libId) {
        Library library = libraryMap.get(libId);
        if (library != null) {
            return Response.status(Response.Status.OK).entity(libraryMap.get(libId)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/books")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewBook(@PathParam("libId") int libId, Book newBook) {
        Library library = libraryMap.get(libId);
        if (library != null) {
            library.getBooks().add(newBook);
            return Response.status(Response.Status.ACCEPTED).entity(library).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/books/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBookByName(@PathParam("name") String name, @PathParam("libId") int libId) {
        Library library = libraryMap.get(libId);
        if (library != null) {
            library.getBooks().removeIf(book -> book.getName().equals(name));
            return Response.status(Response.Status.ACCEPTED).entity(library).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}



