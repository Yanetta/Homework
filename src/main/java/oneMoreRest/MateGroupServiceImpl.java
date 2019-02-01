package oneMoreRest;


import xmljson.HumanResource;
import xmljson.MateGroup;
import xmljson.Person;
import xmljson.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * @author spasko
 */
@Path("/rs/mate/{groupId}")
public class MateGroupServiceImpl implements MateGroupService {
    private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
            .collect(Collectors.toMap(MateGroup::getId, Function.identity()));

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup(@PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(Status.OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudents(@PathParam("groupId") int groupId, Person person) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

//          @Override
//          @DELETE
//          @Path("/students/{surname}")
//          //@Consumes(MediaType.APPLICATION_JSON)
//          @Produces(MediaType.APPLICATION_JSON)
//          public Response deleteStudent(@PathParam("/{surname}") String surname, @PathParam("groupId") int groupId) {
//              MateGroup mateGroup = mateGroups.get(groupId);
//              if (mateGroup != null) {
//                  List<Person> students = mateGroup.getStudents();
//                  for(int i = 0; i <students.size(); i++ ){
//                      if (students.get(i).equals(surname)){
//                          students.remove(i);
//                      }
//                  }
//                  return Response.status(Status.ACCEPTED).type(MediaType.APPLICATION_JSON).build();
//              }
//              return Response.status(Status.NOT_FOUND).build();
//          }

    @Override
    @DELETE
    @Path("/students/{surname}")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@PathParam("/{surname}") String surname, @PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            List<Person> students = mateGroup.getStudents();
            //students.stream().filter(student -> student.getSurname()  getSurname().equals(surname) ).collect(Collectors.toList()));
            students.removeIf(student -> student.getSurname().equals(surname));


            return Response.status(Status.ACCEPTED).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/students/{surname}")
//          @Consumes(MediaType.APPLICATION_JSON)
//          @Produces(MediaType.APPLICATION_JSON)
    public Response renameStudent(@PathParam("surname") String surname, @PathParam("groupId") int groupId, @QueryParam("newname") String newname) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().stream().filter(as -> as.getSurname().equals(surname)).forEach(as -> as.setName(newname));
//                  List<Person> students = mateGroup.getStudents();
//                  for(int i = 0; i <students.size(); i++ ){
//                      if (students.get(i).equals(surname)){
//                          students.get(i).setName(newname);
//                      }
//                  }
            return Response.status(Status.ACCEPTED).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/hrs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHR(@PathParam("groupId")int groupId, HumanResource newHR) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getHumanResources().add(newHR);
            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }
    @Override
    @DELETE
    @Path("/hrs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteHR(@PathParam("/{name}") String name, @PathParam("groupId") int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            Set<HumanResource> humanResources =  mateGroup.getHumanResources();
            //students.stream().filter(student -> student.getSurname()  getSurname().equals(surname) ).collect(Collectors.toList()));
            humanResources.removeIf(hr -> hr.getName().equals(name));
            return Response.status(Status.ACCEPTED).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

}