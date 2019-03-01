import HibernateWork.HibOrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HibTest {
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(113012);

    private HibOrderDaoImpl orderDa = new HibOrderDaoImpl();

    @Test
    public void testFindOrderById() throws SQLException {
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps().getOffices());
          System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getCustomers());
         System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getProducts());
         System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getProducts().getOrdersSet());
          System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps());
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps().getOffices().getSalesrepsSet());
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getCustomers().getOrdersSet());
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps().getCustomersSet());
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps().getOfficesSet());
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps().getOrdersSet());
        System.out.println(orderDa.findOrderById(ALREADY_EXIST_ORDER).getSalesreps().getSalesrepsSet());

    }
}
