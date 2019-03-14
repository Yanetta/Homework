package springAnnotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:springAnnotations/cheese.properties")
public class Cheese {

    @Value("${sort}")
    private String sort;

    private int weight;

    public Cheese() {
        weight = (int) (Math.random() * 1000);
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "sort='" + sort + '\'' +
                ", weight=" + weight +
                '}';
    }
}
