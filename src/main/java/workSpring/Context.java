package workSpring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Context {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("workSpring");
        Pig pig = context.getBean(Pig.class);
        System.out.println(pig.getVoice());
        Tiger tiger = context.getBean("tiger", Tiger.class);
        Tiger tiger23 = context.getBean("tiger23", Tiger.class);
        System.out.println(tiger);
        System.out.println(tiger23);
        Kakadu kakadu = context.getBean(Kakadu.class);
        System.out.println(kakadu);
        Bloha bloha = context.getBean(Bloha.class);
        Bloha bloha1 = context.getBean(Bloha.class);
        System.out.println(bloha);
        System.out.println(bloha1);
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);
        Cat cat1 = context.getBean(Cat.class);
        System.out.println(cat1);

        context.close();
    }
}
