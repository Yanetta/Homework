package TestOrderDaoImpl;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import workwithJDBC.Order;
import workwithJDBC.OrderDaoImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
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
    @Test
    public void test1InsertOrder() throws SQLException {
        System.out.println("testinsertOrder ____________________");
        boolean ins = orderDao.insertOrder(BigDecimal.valueOf(555555), BigDecimal.valueOf(555));
        System.out.println(ins);
        assertTrue(ins);
    }

    @Test
    public void test2InsertOrder() throws SQLException {
        System.out.println("testinsertOrder ____________________");
        boolean ins = orderDao.insertOrder(BigDecimal.valueOf(777777), BigDecimal.valueOf(777));
        System.out.println(ins);
        assertTrue(ins);
    }

    @Test
    public void test3UpdateOrder() throws SQLException {
        System.out.println("testupdateOrder ____________________");
        boolean ins = orderDao.updateOrder(BigDecimal.valueOf(777777));
        assertTrue(ins);
    }

    @Test
    public void test4DeleteOrder() throws SQLException {
        System.out.println("testdeleteeOrder ____________________");

        boolean ins = orderDao.deleteOrder(BigDecimal.valueOf(555555));
        assertTrue(ins);
    }
}
