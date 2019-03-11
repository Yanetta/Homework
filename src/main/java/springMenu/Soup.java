package springMenu;

import org.springframework.stereotype.Component;

@Component("soup")
public class Soup extends AbstractMeal {
    String[] ingredients = {"potato", "onion"};

    @Override
    public String getName() {
        return "soup";
    }

    @Override
    public int getWeight() {
        return 1000;
    }

    @Override
    public int getKalories() {
        return 500;
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
        return "Soup{" + super.toString() +
                "name=" + getName() +
                ", weight=" + getWeight() +
                ", kalories=" + getKalories() +
                ", ingredients=" + Arrays.toString(ingredients) +
                '}';
    }
}
