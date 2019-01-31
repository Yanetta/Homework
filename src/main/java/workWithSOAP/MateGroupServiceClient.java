package workWithSOAP;

import xmljson.Person;
import xmljson.Student;
import xmljson.Teacher;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


/**
 * @author spasko
 */
public class MateGroupServiceClient {


    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/mate?wsdl");

        // 1st argument service URI, refer to wsdl document above
        // 2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://workWithSOAP/", "MateGroupServiceImplService");

        Service service = Service.create(url, qname);

        MateGroupService hello = service.getPort(MateGroupService.class);

        System.out.println(hello.getMateGroup(18122018));

        List<Person> persons = new ArrayList<>();
        persons.add(new Student("First", "First", 1995,5 ));
        persons.add(new Teacher("Second", "Second", 1990, 666, 44, "biology"));
        System.out.println(hello.addStudents(18122018, persons));
        //System.out.println(hello.changeTeacher("Sasha"));


    }

}


