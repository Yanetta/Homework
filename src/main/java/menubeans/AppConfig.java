package menubeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springMenu.Pizza;
import springMenu.Soup;
import springMenu.Sushi;

@Configuration
@ComponentScan("springMenu")
public class AppConfig {
    @Bean("gourmanPizza")
    public Pizza returnPizza() {
        Pizza gourmanPizza = new Pizza();
        gourmanPizza.setCookingTime(30);
        return gourmanPizza;
    }

    @Bean("gourmanSushi")
    public Sushi returnSishi() {
        Sushi gourmanSushi = new Sushi();
        gourmanSushi.setPrice(400);
        return gourmanSushi;
    }

    @Bean("borshch")
    public Soup returnBorshch() {
        Soup borshch = new Soup();
        String[] ingredients = {"potato", "tomato", "meat"};
        borshch.setIngredients(ingredients);
        return borshch;
    }
}