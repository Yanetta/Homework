package hibernateTests;

import HibernateWork.HibOrderDaoImpl;
import JPAwork.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdersDaoImplTestHib {
    private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(113042);

    private HibOrderDaoImpl orderDa = new HibOrderDaoImpl();

    private Orders order = new Orders(BigDecimal.valueOf(222223), null, null, null, "REI", null, BigDecimal.valueOf(500), BigDecimal.valueOf(600));
    private Orders orderUpd = new Orders(BigDecimal.valueOf(222223), null, null, null, "RRR", null, BigDecimal.valueOf(800), BigDecimal.valueOf(900));

    @Test
    public void test3InsertOrder() throws SQLException {
        assertTrue(orderDa.insertOrder(order));
    }

    @Test
    public void test4UpdateOrder() throws SQLException {
        assertTrue(orderDa.updateOrder(orderUpd));
    }

    @Test
    public void test1FindOrderById() throws SQLException {
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

    @Test
    public void test2GetAllOrders() {
        Set<Orders> orders = orderDa.getAllOrders();
        System.out.println(orders);
        assertNotNull(orders);
    }

    @Test
    public void test5deleteOrder() throws SQLException {
        assertTrue(orderDa.deleteOrder(BigDecimal.valueOf(222223)));
    }
}
