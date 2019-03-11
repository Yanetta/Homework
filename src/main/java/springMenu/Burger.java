package springMenu;

import org.springframework.stereotype.Component;

@Component("burger")
public class Burger extends AbstractMeal {
    String[] ingredients = {"meat", "bread"};

    @Override
    public String getName() {
        return "burger";
    }

    @Override
    public int getWeight() {
        return 600;
    }

    @Override
    public int getKalories() {
        return 600;
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
        return "Burger{" + super.toString() +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", kalories=" + getKalories() +
                ", ingredients=" + getIngredients().toString() +
                '}';
    }
}
