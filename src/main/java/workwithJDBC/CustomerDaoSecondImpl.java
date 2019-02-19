package workwithJDBC;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CustomerDaoSecondImpl implements CustomerDaoSecond {

    @Override
    public boolean deleteCustomer(Customers customer, TemplOperation<Customers> operation) throws SQLException {
        return (operation.templateOperationFromInterface(customer));
    }

    @Override
    public boolean updateCustomer(Customers customer, BigDecimal cust_num, TemplOperation<Customers> operation) throws SQLException {
        return (operation.templateOperationFromInterface(customer));
    }

    @Override
    public boolean insertCustomer(Customers customer, TemplOperation<Customers> operation) throws SQLException {
        return (operation.templateOperationFromInterface(customer));
    }
}


