package workWithRest;


        import xmljson.Person;

        import javax.ws.rs.core.Response;

public interface MateGroupService {
    public Response getMateGroup();
    public Response changeTeacher(int groupId, String name);


}
