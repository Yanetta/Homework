package workwithJDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface CustomersDao {
    List<Customers> getAllCustomers() throws SQLException;

    List<Customers> findCustomersByCreditLimit(BigDecimal creditLimit) throws SQLException;

    boolean insertCustomer(BigDecimal cust_num, BigDecimal credit_limit) throws SQLException;

    boolean insertWholeCustomer(Customers customer) throws SQLException;

    boolean updateCustomer(BigDecimal cust_num) throws SQLException;

    boolean updateWholeCustomer(Customers customer, BigDecimal cust_num) throws SQLException;

    boolean deleteCustomer(BigDecimal cust_num) throws SQLException;

    boolean deleteAnotherCustomer(Customers customer) throws SQLException;
}
