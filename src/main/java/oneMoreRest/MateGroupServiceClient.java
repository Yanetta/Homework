package oneMoreRest;


        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.ProtocolException;
        import java.net.URL;

        import javax.ws.rs.core.Response.Status;

/**
 * @author spasko
 */
public class MateGroupServiceClient {

    public static void main(String[] args) {
        try {

            HttpURLConnection conn = getMateGroup();
            showInfo(conn);

            conn = addStudent("123/students");
            showInfo(conn);

            conn = addStudent("18122018/students");
            showInfo(conn);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void showInfo(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != Status.OK.getStatusCode()
                && conn.getResponseCode() != Status.ACCEPTED.getStatusCode()) {
            System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        conn.disconnect();
    }

    private static HttpURLConnection addStudent(String pathParam)
            throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        String input = "{\"name\": \"Iza\",\"yearOfBorn\": 1997	}";

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        return conn;
    }


    private static HttpURLConnection getMateGroup() throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("http://localhost:9998/rs/mate/18122018");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        return conn;
    }
    private static HttpURLConnection addHR(String pathParam)
            throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("http://localhost:9998/rs/mate/" + pathParam);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        String input = "{\"name\": \"Iza\",\"yearOfBorn\": 1997	}";

        OutputStream os = conn.getOutputStream();
        os.write(input.getBytes());
        os.flush();
        return conn;
    }
//    @Path("/hrs")
//    public Response addHR(@PathParam("groupId") int groupId, HumanResource newHR) {
//        MateGroup mateGroup = mateGroups.get(groupId);
//        if (mateGroup != null) {
//            mateGroup.getHumanResources().add(newHR);
//            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
//        }
//        return Response.status(Status.NOT_FOUND).build();
//    }
//
//    @Override
//    @DELETE
//    @Path("/hrs/{name}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteHR(@PathParam("name") String name, @PathParam("groupId") int groupId) {
//        MateGroup mateGroup = mateGroups.get(groupId);
//        if (mateGroup != null) {
//            mateGroup.getHumanResources().removeIf(hr -> hr.getName().equals(name));
//            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
//        }
//        return Response.status(Status.NOT_FOUND).build();
//    }
//
//    @Override
//    @PUT
//    @Path("/hrs/{startWorkYear}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response changeHR(@PathParam("startWorkYear") int startWorkYear, @PathParam("groupId") int groupId, @QueryParam("newStartWorkYear") int newStartWorkYear) {
//        MateGroup mateGroup = mateGroups.get(groupId);
//        if (mateGroup != null) {
//            mateGroup.getHumanResources().stream().filter(as -> as.getStartWorkYear() == startWorkYear).forEach(as -> as.setStartWorkYear(newStartWorkYear));
//            return Response.status(Status.ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
//        }
//        return Response.status(Status.NOT_FOUND).build();
//    }
//
//    @Override
//    @GET
//    @Path("/hrs")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllHrs(@PathParam("groupId") int groupId) {
//        MateGroup mateGroup = mateGroups.get(groupId);
//        if (mateGroup != null) {
//            return Response.status(Status.OK).entity(mateGroup.getHumanResources()).type(MediaType.APPLICATION_JSON).build();
//        }
//        return Response.status(Status.NOT_FOUND).build();
//    }
//
//
//    @Override
//    @GET
//    @Path("/hrs/{name}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getCertainHr(@PathParam("name") String name, @PathParam("groupId") int groupId) {
//        MateGroup mateGroup = mateGroups.get(groupId);
//        if (mateGroup != null) {
//            return Response.status(Status.OK).entity(mateGroup.getHumanResources().stream().filter(as -> as.getName().equals(name)).findAny().get()).type(MediaType.APPLICATION_JSON).build();
//        }
//        return Response.status(Status.NOT_FOUND).build();
//    }

}