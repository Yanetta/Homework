import JPAwork.Customers;
import JPAwork.CustomersDaoImpl;
import JPAwork.OrderDaoImpl;
import JPAwork.Orders;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class CustomersDaoImplTest1 {

    private CustomersDaoImpl customersDao = new CustomersDaoImpl();
    Customers customer = new Customers(BigDecimal.valueOf(2222),
            BigDecimal.valueOf(103), BigDecimal.valueOf(3000), "Apple");

    @Test
    public void test1InsertCustomers() throws SQLException {
        assertTrue(customersDao.insertCustomer(customer));
    }

    @Test
    public void test2updateCustomers() throws SQLException {
        customer.setCompany("Huawey");
        customer.setCust_rep(BigDecimal.valueOf(102));
        assertTrue(customersDao.updateCustomer(customer));
    }

    @Test
    public void test3deleteCustomers() throws SQLException {
        assertTrue(customersDao.deleteCustomer(BigDecimal.valueOf(2222)));
    }
}


