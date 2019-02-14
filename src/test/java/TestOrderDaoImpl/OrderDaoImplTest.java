package TestOrderDaoImpl;

import org.junit.Test;
import workwithJDBC.Order;
import workwithJDBC.OrderDaoImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OrderDaoImplTest {
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(113042);
private OrderDaoImpl orderDao = new OrderDaoImpl();
    @Test
    public void testFindOrderById() throws SQLException {
        System.out.println("findOrderById ____________________");
        Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
        System.out.println(order);
        assertNotNull(order);

    }

    @Test
    public void testGetAllOrders() throws SQLException {
        System.out.println("testGetAllOrders ____________________");
        Set<Order> orders = orderDao.getAllOrders ();
        System.out.println(orders);
        assertTrue(orders.size() > 25);

    }
    @Test
    public void testGetAllOrdersInnerJoin() throws SQLException {
        System.out.println("testGetAllOrdersInnerJoin ____________________");
        Set<Order> orders = orderDao.getAllOrdersInnerJoin ();
        System.out.println(orders);
        assertTrue(orders.size() > 25);
    }

}
