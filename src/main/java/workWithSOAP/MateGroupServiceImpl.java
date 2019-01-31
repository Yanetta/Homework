package workWithSOAP;

import xmljson.MateGroup;
import xmljson.Person;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebService(endpointInterface = "workWithSOAP.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService {
    //public MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
    private Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
            .collect(Collectors.toMap(MateGroup::getId, Function.identity()));
    @Override
    public MateGroup getMateGroup(Integer groupId) {
        return mateGroups.get(groupId);
    }

    @Override
    public MateGroup addStudents(Integer groupId, List<Person> person) {
        //mateGroup.getStudents().addAll(person);
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().addAll(person);
            return mateGroup;
        } else
            return null;
    }

//    @Override
//    public MateGroup changeTeacher(String name) {
//        mateGroup.getTeacher().setName(name);
//        return mateGroup;
//    }
}
