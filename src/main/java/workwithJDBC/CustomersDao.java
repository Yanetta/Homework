package workwithJDBC;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


public interface CustomersDao {
    List<Customers> getAllCustomers() throws SQLException;
    List<Customers> findCustomersByCreditLimit(BigDecimal creditLimit) throws SQLException;
}
