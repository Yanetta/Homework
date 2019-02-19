import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import workwithJDBC.Customers;
import workwithJDBC.CustomersDaoImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class CustomersDaoImplTest {

    private CustomersDaoImpl customersDao = new CustomersDaoImpl();

    @Test
    public void findCustomersByCreditLimit() throws SQLException {
        System.out.println("testFindCustomersByCreditLimit ____________________");
        List<Customers> customers = customersDao.findCustomersByCreditLimit(BigDecimal.valueOf(40));
        System.out.println(customers);
        assertTrue(customers.size() > 10);
    }

    @Test
    public void getAllCustomers() throws SQLException {
        System.out.println("testgetAllCustomers ____________________");
        List<Customers> customersList = customersDao.getAllCustomers();
        System.out.println(customersList);
        assertTrue(customersList.size() > 20);

    }

    @Test
    public void test1InsertCustomer() throws SQLException {
        System.out.println("testInsertCustomer ____________________");
        boolean ins = customersDao.insertCustomer(BigDecimal.valueOf(3333), BigDecimal.valueOf(333));
        System.out.println(ins);
        assertTrue(ins);
    }

    @Test
    public void test2InsertWholeCustomer() throws SQLException {
        System.out.println("testInsertCustomer1 ____________________");
        Customers customer = new Customers();
        customer.setCustNum(BigDecimal.valueOf(4444));
        customer.setCustRep(BigDecimal.valueOf(120));
        customer.setCreditLimit(BigDecimal.valueOf(900));
        customer.setCompany("Apple");
        boolean ins = customersDao.insertWholeCustomer( customer);
        System.out.println(ins);
        assertTrue(ins);
    }

    @Test
    public void test3UpdateCustomer() throws SQLException {
        System.out.println("testUpdateCustomer ____________________");
        boolean ins = customersDao.updateCustomer(BigDecimal.valueOf(3333));
        assertTrue(ins);
    }
    @Test
    public void test4UpdateWholeCustomer() throws SQLException {
        System.out.println("testUpdateCustomer1 ____________________");
        Customers customer = new Customers();
        customer.setCustNum(BigDecimal.valueOf(8888));
        customer.setCustRep(BigDecimal.valueOf(102));
        customer.setCreditLimit(BigDecimal.valueOf(888));
        customer.setCompany("Wood");
        boolean ins = customersDao.updateWholeCustomer(customer, BigDecimal.valueOf(4444));
        assertTrue(ins);
    }

    @Test
    public void test5DeleteCustomer() throws SQLException {
        System.out.println("testDeleteeCustomer ____________________");
        assertTrue(customersDao.deleteCustomer(new BigDecimal(3333)));
    }

    @Test
    public void test6DeleteAnotherCustomer() throws SQLException {
        System.out.println("testDeleteeCustomer ____________________");
        Customers customer = new Customers();
        customer.setCustNum(BigDecimal.valueOf(8888));
        customer.setCustRep(BigDecimal.valueOf(102));
        customer.setCreditLimit(BigDecimal.valueOf(888));
        customer.setCompany("Wood");
        assertTrue(customersDao.deleteAnotherCustomer(customer));
    }
}
