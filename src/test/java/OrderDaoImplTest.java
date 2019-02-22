import JPAwork.OrderDaoImpl;
import JPAwork.Order;

import org.junit.Test;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.assertTrue;


public class OrderDaoImplTest {
    private OrderDaoImpl orderDaoDao = new OrderDaoImpl();
    Order order = new Order("product", BigDecimal.valueOf(123456), null, BigDecimal.valueOf(444), BigDecimal.valueOf(56), "REI");


    @Test
    public void test1InsertOrder() throws SQLException{
    assertTrue(orderDaoDao.insertOrder(order));
    }
}
