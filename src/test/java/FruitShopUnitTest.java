import fruitShop.Fruit;
import fruitShop.FruitShop;
import fruitShop.FruitType;
import org.junit.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FruitShopUnitTest {

    private FruitShop fruitShop;
    private static Fruit apple;
    private static Fruit pear;
    private static Fruit strawberry;
    private static Fruit orange;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
        apple = new Fruit(FruitType.APPLE, 55, LocalDate.of(2019, Month.JANUARY, 19), 15, null);
        pear = new Fruit(FruitType.PEAR, 42, LocalDate.of(2019, Month.JANUARY, 21), 70, null);
        strawberry = new Fruit(FruitType.STRAWBERRY, 13, LocalDate.of(2018, Month.DECEMBER, 20), 150, null);
        orange = new Fruit(FruitType.ORANGE, 58, LocalDate.of(2018, Month.DECEMBER, 17), 35, null);
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void initTest() {
        System.out.println("Before");
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(pear);
        fruits.add(strawberry);
        fruits.add(orange);
        fruitShop = new FruitShop("Fruit shop", fruits);
    }

    @After
    public void afterTest() {
        System.out.println("After");
        fruitShop = null;
    }

    @Test
    public void testAllFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);

        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.FEBRUARY, 28));

        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshNothing() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2020, Month.FEBRUARY, 28));
        assertTrue(actual.size() == 0);
    }





}
