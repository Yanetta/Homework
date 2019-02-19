package workwithJDBC;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface CustomerDaoSecond {
    boolean deleteCustomer(Customers customer, TemplOperation<Customers> operation) throws SQLException;
    boolean updateCustomer(Customers customer,BigDecimal cust_num, TemplOperation<Customers> operation) throws SQLException;
    boolean insertCustomer(Customers customer, TemplOperation<Customers> operation) throws SQLException;

}
