package workSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    @Autowired
    private Bloha bloha;
    private String catid;

    public Cat(){
        catid = "Cat" + (int)(Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "bloha=" + bloha +
                ", catid='" + catid + '\'' +
                '}';
    }
}
