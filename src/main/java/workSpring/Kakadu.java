package workSpring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.ext.ParamConverter;

@Lazy
@Component
public class Kakadu {
    private String name;
    private int weight;

    public Kakadu(@Value("DefaultName") String name, @Value("1") int weight) {
        this.name = name;
        this.weight = weight;
        System.out.println("in constructor" + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @PostConstruct
    private void init(){
        name = this.getClass().getSimpleName();
        System.out.println("init method" + this);
    }
    @PreDestroy
    private void preDestroy(){
        System.out.println("in predestroy" + this);
    }
    @Override
    public String toString() {
        return "Kakadu{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
