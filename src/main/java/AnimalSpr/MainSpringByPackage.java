package AnimalSpr;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpringByPackage {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("AnimalSpr");

        Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("doggy");
        Mouse mouse = context.getBean("mikky", Mouse.class);
        Animal animal = context.getBean(Animal.class);
        Animal anim = context.getBean( Mouse.class);
        System.out.println(cat);
        System.out.println(dog);
        System.out.println(mouse);
        System.out.println(animal);
        System.out.println(anim);

        context.close();
    }
}
