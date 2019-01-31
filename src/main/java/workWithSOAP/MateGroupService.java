package workWithSOAP;

import xmljson.MateGroup;
import xmljson.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.List;
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface MateGroupService {
    @WebMethod
    public MateGroup getMateGroup();
    @WebMethod
    public  MateGroup addStudents(List<Person> person);
    @WebMethod
    public MateGroup changeTeacher(String name);

}
