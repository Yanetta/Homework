package AnimalSpr;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("catty")
@Primary
public class Cat extends  AbstractAnimal {
    @Override
    public String getVoice(){
        return "mur";
    }
}
