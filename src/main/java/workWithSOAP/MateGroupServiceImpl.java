package workWithSOAP;

import xmljson.MateGroup;
import xmljson.Person;

import javax.jws.WebService;
import java.util.List;
@WebService(endpointInterface = "workWithSOAP.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService {
    public MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
    @Override
    public MateGroup getMateGroup() {
        return mateGroup;
    }

    @Override
    public MateGroup addStudents(List<Person> person) {
        mateGroup.getStudents().addAll(person);
        return mateGroup;
    }
}
