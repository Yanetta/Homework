package workWithSOAP;

import xmljson.MateGroup;
import xmljson.Person;
//import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.List;
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface MateGroupService {
    @WebMethod
    public MateGroup getMateGroup(Integer groupId);
    @WebMethod
    public  MateGroup addStudents(Integer groupId, List<Person> person);
//    @WebMethod
//    public MateGroup changeTeacher(String name);

}
