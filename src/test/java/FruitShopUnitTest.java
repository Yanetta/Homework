import fruitShop.Fruit;
import fruitShop.FruitShop;
import fruitShop.FruitType;
import org.junit.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

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

    @Test(expected = NullPointerException.class)
    public void testAllFreshNull() {
        fruitShop.allFresh(null);
    }


    @Test
    public void testAllFruitOfFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.APPLE);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFruitOfFruitTypeNotNull() {
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.APPLE);
        Assert.assertNotNull(actual);
    }

    @Test
    public void testCheckByExpireDate() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(orange);
        List<Fruit> actual = fruitShop.checkByExpireDate(50);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckByExpireDateNothing() {
        List<Fruit> actual = fruitShop.checkByExpireDate(100);
        assertTrue(actual.size() == 0);
    }

    @Test
    public void testAllFreshAndFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(orange);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.ORANGE, LocalDate.of(2019, Month.JANUARY, 21));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshAndFruitTypeNotNull() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.ORANGE, LocalDate.of(2019, Month.JANUARY, 21));
        Assert.assertNotNull(actual);
    }

    @Test
    public void testAllFreshAndFruitTypeNothing() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.ORANGE, LocalDate.of(2020, Month.JANUARY, 21));
        assertTrue(actual.size() == 0);
    }

    @Test
    public void testReSetPricexRealizationFalse() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        List<Fruit> actual = fruitShop.reSetPricexRealization(50, 3, FruitType.APPLE);
        assertFalse(actual.size() == 0);
    }

    @Test
    public void testReSetPricexRealizationNothing() {
        List<Fruit> actual = fruitShop.reSetPricexRealization(50, 1, FruitType.ORANGE, FruitType.APPLE, FruitType.PEAR, FruitType.STRAWBERRY);
        assertTrue(actual.size() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void testReSetPricexRealizationNull() {
        fruitShop.reSetPricexRealization(50, 1, null);
    }

}
