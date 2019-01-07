package streamsAndLiambdas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static streamsAndLiambdas.FruitType.*;
import static streamsAndLiambdas.Vitamins.*;

/**
 * @author Tetiana Pedchenko
 */
public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();

        System.out.println("\n foreach:");
        fruits.forEach(System.out::println);

        System.out.println("\n filter:");
        fruits.stream().filter(fruit -> fruit.getFruitType().equals(FruitType.PEAR)).forEach(System.out::println);

        System.out.println("\n skip:");
        fruits.stream().skip(4).forEach(obj -> System.out.println(obj));

        System.out.println("\n distinct:");
        fruits.stream().distinct().forEach(System.out::println);

        System.out.println("\n map:");
        fruits.stream().map(fruit -> fruit.getFruitType() + " " + fruit.getPrice()).forEach(System.out::println);

        System.out.println("\n map:");
        fruits.stream().map(Fruit::getFruitTypeAndPrice).forEach(System.out::println);

        System.out.println("\n peek:");
        fruits.stream().peek(System.out::println).map(Fruit::getFruitTypeAndPrice).forEach(System.out::println);

        System.out.println("\n limit:");
        fruits.stream().limit(4).forEach(obj -> System.out.println(obj));

        System.out.println("\n sorted:");
        Comparator<Fruit> comparator = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                int r = o1.getFruitType().toString().compareTo(o2.getFruitType().toString());
                if (r != 0) {
                    return r;
                } else {
                    return o1.getPrice() - o2.getPrice();
                }
            }
        };
        fruits.stream().sorted(comparator).forEach(System.out::println);

        System.out.println("\n mapToInt: ");
        fruits.stream().mapToInt(Fruit::getPrice).forEach(System.out::println);

        System.out.println("\n flatMap: ");
        fruits.stream().map(Fruit::getVitamins).flatMap(vitamins -> vitamins.stream()).forEach(System.out::println);

        System.out.println("\n findFirst: ");
        System.out.println(fruits.stream().mapToInt(Fruit::getPrice).findFirst().orElse(1));

        System.out.println("\n findAny: ");
        System.out.println(fruits.stream().filter(fruit -> fruit.getFruitType().equals(FruitType.APPLE)).findAny().get());

        System.out.println("\n count: ");
        System.out.println(fruits.stream().filter(fruit -> fruit.getPrice() >= 30).count());

        System.out.println("\n anyMatch: ");
        System.out.println(fruits.stream().anyMatch(fruit -> fruit.getPrice() == 30));

        System.out.println("\n noneMatch: ");
        System.out.println(fruits.stream().noneMatch(fruit -> fruit.getPrice() == 30));

        System.out.println("\n allMatch: ");
        System.out.println(fruits.stream().allMatch(fruit -> fruit.getPrice() >= 10));

        System.out.println("\n min: ");
        Comparator<Fruit> comparatorOfPrice = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getPrice() - o2.getPrice();
            }
        };
        System.out.println(fruits.stream().min(comparatorOfPrice).get());

        System.out.println("\n max: ");
        System.out.println(fruits.stream().max(comparatorOfPrice).get());

        System.out.println("\n forEachOrdered: ");
        fruits.stream().mapToInt(Fruit::getPrice).forEachOrdered(obj -> System.out.println("Price - " + obj));

        System.out.println("\n toArray: ");
        for (String s : fruits.stream().map(fruit -> fruit.getFruitType() + " " + fruit.getPrice()).toArray(size -> new String[size])) {
            System.out.println(s);
        }

        System.out.println("\n reduce: ");
        System.out.println(fruits.stream().mapToInt(Fruit::getPrice).reduce((n1, n2) -> n1 + n2).orElse(0));
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{B, C}));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, C}));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, B1, B2, C}));
        fruits.add(fruit);

        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{E, B, A}));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, C, D}));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, B, B1, B2, P}));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{B1, B2, P}));
        fruits.add(fruit);

        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{B, C}));
        fruits.add(fruit);

        return fruits;
    }
}
