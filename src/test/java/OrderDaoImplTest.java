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
}
