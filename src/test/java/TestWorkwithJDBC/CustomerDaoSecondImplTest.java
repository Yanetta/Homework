package TestWorkwithJDBC;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import workwithJDBC.CustomerDaoSecondImpl;
import workwithJDBC.Customers;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerDaoSecondImplTest {

    private static CustomerDaoSecondImpl customersDao;
    private static Customers customer1;
    private static Customers customer2;

    @BeforeClass
    public static void beforeClass() {
        customersDao = new CustomerDaoSecondImpl();
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
    public void test1InsertWholeCustomer() throws SQLException {
        System.out.println("testInsertCustomer1 ____________________");
        boolean ins = customersDao.insertWholeCustomer( customer1);
        System.out.println(ins);
        assertTrue(ins);
    }
    @Test
    public void test2UpdateWholeCustomer() throws SQLException {
        System.out.println("testUpdateCustomer1 ____________________");
        boolean ins = customersDao.updateWholeCustomer(customer2, BigDecimal.valueOf(3333));
        assertTrue(ins);
    }

    @Test
    public void test3deleteAnotherCustomer() throws SQLException {
        System.out.println("testDeleteeCustomer ____________________");
        assertTrue(customersDao.deleteAnotherCustomer(customer2));
    }

}
