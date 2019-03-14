package springAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:springAnnotations/pizza.properties")
@DependsOn("meat")
@Component
public class Pizza {

    @Value("${name}")
    private String name;

    @Autowired
    @Qualifier( "cheese")
    private Cheese cheese;

    @Autowired
    private Meat meat;

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight() {
        this.weight = cheese.getWeight() + meat.getWeight();;
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", cheese=" + cheese +
                ", meat=" + meat +
                '}';
    }
}
