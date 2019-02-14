import org.junit.Test;
import workwithJDBC.Customers;
import workwithJDBC.CustomersDaoImpl;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertTrue;

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
            List<Customers> customersList = customersDao.getAllCustomers ();
            System.out.println(customersList);
            assertTrue(customersList.size() > 20);

        }
    }
