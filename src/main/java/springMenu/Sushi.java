package springMenu;

import org.springframework.stereotype.Component;

@Component("sushi")
public class Sushi extends AbstractMeal {
    String[] ingredients = {"rice", "fish"};

    @Override
    public String getName() {
        return "sushi";
    }

    @Override
    public int getWeight() {
        return 200;
    }

    @Override
    public int getKalories() {
        return 600;
    }

    @Override
    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Sushi{" + super.toString() +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", kalories=" + getKalories() +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
