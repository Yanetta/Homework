package TestOrderDaoImpl;

import org.junit.Test;
import workwithJDBC.Order;
import workwithJDBC.OrderDaoImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class OrderDaoImplTest {
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(113042);
private OrderDaoImpl orderDao = new OrderDaoImpl();
    @Test
    public void testFindOrderById() throws SQLException {
        Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
        System.out.println(order);
        assertNotNull(order);
    }

    @Test
    public void testFindOrderByIdNull() throws SQLException {
        Order order = orderDao.findOrderById(BigDecimal.valueOf(3));
        System.out.println(order);
        assertNotNull(order);
    }


}
