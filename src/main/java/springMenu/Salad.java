package springMenu;

import org.springframework.stereotype.Component;

@Component("salad")
public class Salad extends AbstractMeal {
    String[] ingredients = {"leaves", "sous"};

    @Override
    public String getName() {
        return "salad";
    }

    @Override
    public int getWeight() {
        return 400;
    }

    @Override
    public int getKalories() {
        return 300;
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
        return "Salad{" + super.toString() +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", kalories=" + getKalories() +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
