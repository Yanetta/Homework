package AnimalSpr;

import org.springframework.stereotype.Component;

@Component("mikky")
public class Mouse extends AbstractAnimal {
    @Override
    public String getVoice() {
        return "Pi";
    }
}
