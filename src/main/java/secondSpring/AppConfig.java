package secondSpring;

import AnimalSpr.AbstractAnimal;
import AnimalSpr.Cat;
import AnimalSpr.Dog;
import AnimalSpr.Mouse;
import calculator.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("AnimalSpr")
public class AppConfig {
    @Primary
    @Bean("catty")
    public Cat returnCat() {
        return new Cat();
    }

    @Bean("doggy")
    public Dog returnDog() {
        return new Dog();
    }

    @Bean("mikky")
    public Mouse returnMouse() {
        return new Mouse();
    }

    @Bean("pig1")
    public Pig returnPig() {
        Pig pig = new Pig();
        pig.setColor("green");
        return pig;
    }

    @Component("pig2")
    class Pig extends AbstractAnimal {
        private String color;

        public String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Pig{" + super.toString() +
                    "color='" + color + '\'' +
                    '}';
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String getVoice() {
            return "hru";
        }
    }
}
