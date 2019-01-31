package workWithRest;

import xmljson.MateGroup;
import xmljson.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Arrays;


/**
 * @author spasko
 */
@Path("/rs/mate")
public class MateGroupServiceImpl implements MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response getMateGroup() {
        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }
//
//    @Override
//    @PUT
//    @Path("/{groupId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
//        if (groupId == mateGroup.getId()) {
//            mateGroup.getStudents().addAll(Arrays.asList(person));
//            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
//        }
//        return Response.status(Status.NOT_FOUND).build();
//    }
//

    @Override
    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeTeacher(@PathParam("groupId") int groupId, String name) {
        if (groupId == mateGroup.getId()) {
            mateGroup.getTeacher().setName(name);
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
}
