package JPAwork;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface CustomersDao {

    boolean insertCustomer(Customers customer);

    boolean updateCustomer(Customers customer);

    boolean deleteCustomer(BigDecimal cust_num);
}
