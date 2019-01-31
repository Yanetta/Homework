package oneMoreRest;


        import xmljson.Person;

        import javax.ws.rs.core.Response;


/**
 * @author spasko
 */

public interface MateGroupService {

    public Response getMateGroup(int groupId);

    public Response addStudents(int groupId, Person person);

    public  Response deleteStudent(String surname, int groupId);

    public  Response renameStudent(String surname, int groupId, String newname);
}