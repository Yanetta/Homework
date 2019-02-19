package TestOrderDaoImpl;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import workwithJDBC.CustomerDaoSecondImpl;
import workwithJDBC.Customers;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoSecondImplTest {

    private static CustomerDaoSecondImpl customersDaoSecond;
    private static Customers customer1;
    private static Customers customer2;

    @BeforeClass
    public static void beforeClass() {
        customersDaoSecond = new CustomerDaoSecondImpl();
        customer1 = new Customers();
        customer2 = new Customers();
        customer1.setCustNum(BigDecimal.valueOf(3333));
        customer1.setCustRep(BigDecimal.valueOf(103));
        customer1.setCreditLimit(BigDecimal.valueOf(888));
        customer1.setCompany("Wood");
        customer2.setCustNum(BigDecimal.valueOf(4444));
        customer2.setCustRep(BigDecimal.valueOf(104));
        customer2.setCreditLimit(BigDecimal.valueOf(400));
        customer2.setCompany("Gold");
    }

    @Test
    public void Test1InsertCustomer() throws SQLException {
        String sql = "INSERT INTO customers (cust_num, company, cust_rep, credit_limit) VALUES (?, ?, ?, ?)";
        assertTrue(customersDaoSecond.insertCustomer(customer1, (customers, conn) -> {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBigDecimal(1, customer1.getCustNum());
            stmt.setString(2, customer1.getCompany());
            stmt.setBigDecimal(3, customer1.getCustRep());
            stmt.setBigDecimal(4, customer1.getCreditLimit());
            return stmt;
        }));
    }

    @Test
    public void Test2UpdateCustomer() throws SQLException {
        String sql = "update customers set cust_num = ?, company = ?, cust_rep = ?,credit_limit = ? where cust_num = ?";
        BigDecimal cust_num = new BigDecimal(3333);
        assertTrue(customersDaoSecond.updateCustomer(customer1, cust_num, (customers, conn) -> {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBigDecimal(1, customer2.getCustNum());
            stmt.setString(2, customer2.getCompany());
            stmt.setBigDecimal(3, customer2.getCustRep());
            stmt.setBigDecimal(4, customer2.getCreditLimit());
            stmt.setBigDecimal(5, cust_num);
            return stmt;
        }));


    }

    @Test
    public void Test3DeleteCustomer() throws SQLException {
        System.out.println("testDeleteCustomer ____________________");

        String sql = "DELETE FROM customers where cust_num = ?";
        assertTrue(customersDaoSecond.deleteCustomer(customer2, (customers, conn) -> {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBigDecimal(1, customer2.getCustNum());
            return stmt;
        }));
    }

}
