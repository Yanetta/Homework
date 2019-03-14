package springAnnotations;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FoodDelivery {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("springAnnotations");

        Meat salami = context.getBean(Meat.class);
        System.out.println(salami.getType() + salami.getWeight());

        Cheese chedder = context.getBean("cheese", Cheese.class);
        System.out.println(chedder.getSort() + chedder.getWeight());

        Pizza pizza = context.getBean(Pizza.class);
        System.out.println(pizza + " meat weight" + pizza.getMeat().getWeight() + " cheese weight" + pizza.getCheese().getWeight());

        Pizza pizza1 = context.getBean(Pizza.class);
        System.out.println(pizza1 + " meat weight" + pizza1.getMeat().getWeight() + " cheese weight" + pizza1.getCheese().getWeight());

        Sushi sushi = context.getBean(Sushi.class);
        System.out.println(sushi);

        Cheese cheese2 = context.getBean("cheese2", Cheese.class);
        System.out.println(cheese2);

        context.close();
    }
}
