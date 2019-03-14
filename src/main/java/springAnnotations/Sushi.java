package springAnnotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Lazy
@Component
public class Sushi {
    private String name;
    private int price;

    public Sushi(@Value("TunaSushi") String name, @Value("100") int price) {
        this.name = name;
        this.price = price;
        System.out.println("in constructor" + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @PostConstruct
    private void init(){
        name = this.getClass().getSimpleName();
        System.out.println("init method" + this);
    }
    @PreDestroy
    private void preDestroy(){
        name = "salmonSushi";
        System.out.println("in predestroy" + this);
    }

    @Override
    public String toString() {
        return "Sushi{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
