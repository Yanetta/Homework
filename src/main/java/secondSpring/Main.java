package secondSpring;

import AnimalSpr.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat = context.getBean(Cat.class);
        Dog dog =  context.getBean("doggy", Dog.class);
        Mouse mouse = context.getBean("mikky", Mouse.class);
        Animal anim = context.getBean( Mouse.class);
//        Animal pigAnimal = context.getBean("pig", AppConfig.Pig.class);
//        AppConfig.Pig pig = context.getBean("pig",AppConfig.Pig.class);
        AppConfig.Pig pig2 = context.getBean("pig2", AppConfig.Pig.class);
        Animal pig1 = context.getBean("pig1", Animal.class);
        Animal ani = context.getBean(Animal.class);
//        Dog dog = (Dog) context.getBean("doggy");
//        Mouse mouse = context.getBean("mikky", Mouse.class);
//        Animal animal = context.getBean(Animal.class);
//        Animal anim = context.getBean( Mouse.class);
        System.out.println(cat);
        System.out.println(dog);
        System.out.println(mouse);
//        System.out.println(pig);
//        System.out.println(pigAnimal);
        System.out.println(anim);
        System.out.println(pig2);
        System.out.println(pig1);
        System.out.println(ani);

        context.close();
    }
}
