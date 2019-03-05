package workTomcat;

import xmljson.HumanResource;
import xmljson.MateGroup;
import xmljson.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Path("/rs/mate/{groupId}")

public class TomcatServlet {
    private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
            .collect(Collectors.toMap(MateGroup::getId, Function.identity()));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup(@PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(Response.Status.OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(Response.Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/students/{surname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@PathParam("surname") String surname, @PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            List<Person> students = mateGroup.getStudents();
            students.removeIf(student -> student.getSurname().equals(surname));
            return Response.status(Response.Status.ACCEPTED).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/students/{surname}")
    public Response renameStudent(@PathParam("surname") String surname, @PathParam("groupId") int groupId, @QueryParam("newname") String newname) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().stream().filter(as -> as.getSurname().equals(surname)).forEach(as -> as.setName(newname));
            return Response.status(Response.Status.ACCEPTED).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/hrs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHR(@PathParam("groupId") int groupId, HumanResource newHR) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getHumanResources().add(newHR);
            return Response.status(Response.Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/hrs/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteHR(@PathParam("name") String name, @PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getHumanResources().removeIf(hr -> hr.getName().equals(name));
            return Response.status(Response.Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/hrs/{startWorkYear}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeHR(@PathParam("startWorkYear") int startWorkYear, @PathParam("groupId") int groupId, @QueryParam("newStartWorkYear") int newStartWorkYear) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getHumanResources().stream().filter(as -> as.getStartWorkYear() == startWorkYear).forEach(as -> as.setStartWorkYear(newStartWorkYear));
            return Response.status(Response.Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/hrs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHrs(@PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(Response.Status.OK).entity(mateGroup.getHumanResources()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @GET
    @Path("/hrs/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCertainHr(@PathParam("name") String name, @PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(Response.Status.OK).entity(mateGroup.getHumanResources().stream().filter(as -> as.getName().equals(name)).collect(Collectors.toSet())).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}



