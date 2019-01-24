import fruitShop.Fruit;
import fruitShop.FruitShop;
import fruitShop.FruitType;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static fruitShop.FruitType.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class FruitShopMockSpy {

    @Spy
    @InjectMocks
    private FruitShop fruitShop;
    @Mock
    private List<Fruit> fruits;
    @Mock
    private Fruit apple;
    @Mock
    private Fruit pear;
    @Mock
    private Fruit strawberry;
    @Mock
    private Fruit orange;

    @Before
    public void setUp() {
        createFruitMock(apple, FruitType.APPLE, LocalDate.of(2019, Month.JANUARY, 15), 55);
        createFruitMock(pear, FruitType.PEAR, LocalDate.of(2019, Month.JANUARY, 16), 45);
        createFruitMock(strawberry, FruitType.STRAWBERRY, LocalDate.of(2018, Month.DECEMBER, 6), 60);
        createFruitMock(orange, FruitType.ORANGE, LocalDate.of(2019, Month.JANUARY, 10), 40);
        when(fruitShop.getFruits()).thenReturn(Arrays.asList(new Fruit[]{apple, pear, strawberry, orange}));
    }

    private void createFruitMock(Fruit fruit, FruitType fruitType, LocalDate date, int timeTolive) {
        when(fruit.getDeliveryDate()).thenReturn(date);
        when(fruit.getDayToLive()).thenReturn(timeTolive);
        when(fruit.clone()).thenReturn(fruit);
        when(fruit.getFruitType()).thenReturn(fruitType);
    }

    @Test
    public void testAllFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.FEBRUARY, 20));
        verify(apple, times(1)).clone();
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFruitOfFruitTypeApple() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(APPLE);
        assertEquals(expected, actual);
        verify(apple, times(1)).getFruitType();
    }

    @Test
    public void testAllFruitOfFruitTypeStrawberry() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(strawberry);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(STRAWBERRY);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckByExpireDate() {
        doReturn(Arrays.asList(orange)).when(fruitShop).checkByExpireDate(30);
        List<Fruit> expected = Arrays.asList(orange);
        List<Fruit> actual = fruitShop.checkByExpireDate(30);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshEmpty() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2025, Month.JULY, 1));
        assertTrue(actual.size() == 0);
    }

    @Test
    public void testAllFreshAndFruitTypePear() {
        doReturn(Arrays.asList(pear)).when(fruitShop).allFruitOfFruitType(FruitType.PEAR);
        List<Fruit> expected = new ArrayList<>();
        expected.add(pear);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2019, Month.JANUARY, 24));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshAndFruitTypeApple() {
        doReturn(Arrays.asList(apple)).when(fruitShop).allFruitOfFruitType(FruitType.APPLE);
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, Month.JANUARY, 20));
        assertEquals(expected, actual);
    }
}
