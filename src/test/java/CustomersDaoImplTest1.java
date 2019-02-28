import JPAwork.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomersDaoImplTest1 {

    private CustomersDaoImpl customersDao = new CustomersDaoImpl();
////    Customers customer = new Customers(BigDecimal.valueOf(2222),
////            BigDecimal.valueOf(103), BigDecimal.valueOf(3000), "Apple");
//
//    @Test
//    public void test1InsertCustomers() throws SQLException {
//        assertTrue(customersDao.insertCustomer(customer));
//    }
//
//    @Test
//    public void test2updateCustomers() throws SQLException {
//        customer.setCompany("Huawey");
//        customer.setCust_rep(BigDecimal.valueOf(102));
//        assertTrue(customersDao.updateCustomer(customer));
//    }

    @Test
    public void test3deleteCustomers() throws SQLException {
        assertTrue(customersDao.deleteCustomer(BigDecimal.valueOf(2222)));
    }

    @Test
    public void testFindOrderById() throws SQLException {
        System.out.println("findCustomerById ____________________");
        Customers customers = customersDao.findCustomerById(BigDecimal.valueOf(2105));
        System.out.println(customers);
        assertNotNull(customers);
    }
}


