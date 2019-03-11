package AnimalSpr;

import org.springframework.stereotype.Component;

@Component("doggy")
public class Dog extends AbstractAnimal {
    @Override
    public String getVoice(){
        return "gav";
    }
}
