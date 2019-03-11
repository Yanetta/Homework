package menubeans;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springMenu.Pizza;
import springMenu.Soup;
import springMenu.Sushi;

public class FoodDelivery {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Pizza gourmanPizza = context.getBean("gourmanPizza", Pizza.class);
        Sushi gourmanSushi = context.getBean("gourmanSushi", Sushi.class);
        Soup borshch = context.getBean("borshch", Soup.class);
        System.out.println(gourmanPizza);
        System.out.println(gourmanSushi);
        System.out.println(borshch);

        context.close();
    }
}
