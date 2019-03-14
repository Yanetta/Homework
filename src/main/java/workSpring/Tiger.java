package workSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@DependsOn("pig")
public class Tiger {
    @Autowired
    //@Qualifier("piggy")
    private Pig pig;
            //= new Pig() {
//        @Override
//        public String getVoice() {
//            return "Pig never die!";
//        }
//    };
    private String voice;

    public Tiger() {
    }

//    @Autowired
//       public Tiger(Pig pig) {
//        this.pig = pig;
//    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return "Tiger say " + getVoice() + (Objects.nonNull(pig) ? " and very like animal that said:" + pig.getVoice() : "");

    }
}
