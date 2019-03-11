package springMenu;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("pizza")
//@Primary
public class Pizza extends AbstractMeal {
    String[] ingredients = {"cheese", "saliami"};

    @Override
    public String getName() {
        return "pizza";
    }

    @Override
    public int getWeight() {
        return 800;
    }

    @Override
    public int getKalories() {
        return 2000;
    }

    @Override
    public String[] getIngredients() {
        return new String[0];
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" + super.toString() +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", kalories=" + getKalories() +
                ", ingredients=" + getIngredients().toString() +
                '}';
    }

}
