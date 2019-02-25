import JPAwork.OrderDaoImpl;
import JPAwork.Orders;

import org.junit.Test;
import java.math.BigDecimal;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;

public class OrderDaoImplTest {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    Orders order = new Orders(BigDecimal.valueOf(123456), null,
            BigDecimal.valueOf(2103), BigDecimal.valueOf(103), "REI", "41004",BigDecimal.valueOf(222), BigDecimal.valueOf(2000));

    @Test
    public void test1InsertOrder() throws SQLException{
    assertTrue(orderDao.insertOrder(order));
    }
    @Test
    public void test2updateOrder() throws SQLException {
        order.setAmount(BigDecimal.valueOf(333));
        order.setQty(BigDecimal.valueOf(999));
        assertTrue(orderDao.updateOrder(order));
    }
    @Test
    public void test3deleteOrder() throws SQLException {
        assertTrue(orderDao.deleteOrder(BigDecimal.valueOf(123456)));
    }
}
