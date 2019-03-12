package springMenu;

import animalSpr.Animal;
import animalSpr.Cat;
import animalSpr.Dog;
import animalSpr.Mouse;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FoodDelivery {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("springMenu");
Burger burger = context.getBean(Burger.class);
Pizza pizza = context.getBean(Pizza.class);
Salad salad = context.getBean(Salad.class);
AbstractMeal soup = context.getBean("soup", Soup.class);
Eatable sushi = context.getBean("sushi", Sushi.class);
        System.out.println(burger);
        System.out.println(pizza);
        System.out.println(salad);
        System.out.println(soup);
        System.out.println(sushi);
        context.close();
    }
}
