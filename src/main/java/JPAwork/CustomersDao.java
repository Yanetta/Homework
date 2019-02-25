package JPAwork;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface CustomersDao {

    boolean insertCustomer(Customers customer) throws SQLException;

    boolean updateCustomer(Customers customer) throws SQLException;

    boolean deleteCustomer(BigDecimal cust_num) throws SQLException;
}
