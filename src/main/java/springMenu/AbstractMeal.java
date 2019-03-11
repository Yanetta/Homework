package springMenu;

public abstract class AbstractMeal implements Eatable {
    int price = 200;
    int cookingTime = 20;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getCookingTime() {
        return cookingTime;
    }

    @Override
    public abstract String getName();

    @Override
    public abstract int getWeight();

    @Override
    public abstract int getKalories();

    @Override
    public   abstract   String[] getIngredients();

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return "AbstractMeal{" +
                "price=" + price +
                ", cookingTime=" + cookingTime +
                '}';
    }
}


