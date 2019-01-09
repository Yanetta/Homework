package cloningExceptionsReflection;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cloningExceptionsReflection.FruitType.*;
import static cloningExceptionsReflection.Vitamins.*;

/**
 * @author Tetiana Pedchenko
 */

public class Main {

    public static void main(String[] args) {
        List<Fruit1> fruit1s = fillFruitsList();


        System.out.println("Exceptions:");

        fruit1s.get(1).setWeight(300);
        System.out.println(fruit1s.get(1).getWeight());

        try {
            fruit1s.get(1).divide();
        } catch (ArithmeticException e) {
            System.out.println("You Shouldn't divide a number by zero");
        }

        try {
            fruit1s.get(0).setColor();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The color of fruit is " + fruit1s.get(0).getColor());

        try {
            fruit1s.get(0).setDescription();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(fruit1s.get(0).getDescription());

        try {

            fruit1s.get(2).printVitamins();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You shouldn't call array element, which index is out of array length ");
        }


        System.out.println("Reflection:");

        Animal animal = new Animal("Kitten", 1);

        Field[] fs = animal.getClass().getDeclaredFields();
        System.out.println(Arrays.toString(fs));

        Method[] ms = animal.getClass().getDeclaredMethods();
        System.out.println(Arrays.toString(ms));

        try {
            Method method = animal.getClass().getDeclaredMethod("someInternalLogic");
            method.setAccessible(true);
            method.invoke(animal);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(animal.toString());

        Animal myAnimal = null;
        try {
            Class refClass2 = Class.forName(Animal.class.getName());
            Constructor[] constructors = refClass2.getConstructors();
            Class[] paramTypes = null;
            for (Constructor constructor : constructors) {
                paramTypes = constructor.getParameterTypes();
                for (Class paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
            myAnimal = (Animal) refClass2.getConstructor(paramTypes).newInstance("Fox", 2);
            System.out.println(myAnimal.toString());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Constructor<Animal> constructor = null;
        try {
            constructor = Animal.class.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        constructor.setAccessible(true);
        Animal an = null;
        try {
            an = constructor.newInstance(new Object[0]);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(an);


        System.out.println("Cloning:");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous;

        try {
            ous = new ObjectOutputStream(baos);
            ous.writeObject(fruit1s);
            ous.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Fruit1> cloneFruit1s = null;
        try {
            cloneFruit1s = (List<Fruit1>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        fruit1s.forEach(System.out::println);
        System.out.println("*********************************************");
        cloneFruit1s.forEach(System.out::println);
        System.out.println("*********************************************");

        cloneFruit1s.get(0).setPrice(300);
        cloneFruit1s.get(1).setPrice(300);
        cloneFruit1s.get(2).setPrice(300);
        cloneFruit1s.get(3).setPrice(300);
        cloneFruit1s.get(4).setPrice(300);
        cloneFruit1s.get(5).setPrice(300);
        cloneFruit1s.get(6).setPrice(300);
        cloneFruit1s.get(7).setPrice(300);

        fruit1s.forEach(System.out::println);
        System.out.println("*********************************************");
        cloneFruit1s.forEach(System.out::println);
    }


    private static List<Fruit1> fillFruitsList() {
        List<Fruit1> fruit1s = new ArrayList<>();

        Fruit1 fruit1 = new Fruit1(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{B, C}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{A, C}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{A, B1, B2, C}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{E, B, A}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{A, C, D}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{A, B, B1, B2, P}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit1.setVitamins(Arrays.asList(new cloningExceptionsReflection.Vitamins[]{B1, B2, P}));
        fruit1s.add(fruit1);

        fruit1 = new Fruit1(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit1.setVitamins(Arrays.asList(new Vitamins[]{B, C}));
        fruit1s.add(fruit1);

        return fruit1s;
    }
}


