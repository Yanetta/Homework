package workwithJDBC;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoSecondImpl implements CustomersDao {


    @Override
    public boolean insertWholeCustomer(Customers customer) throws SQLException {
        TemplOperation<Customers> templOperation = (customers, conn) -> {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO customers (cust_num, company, cust_rep, credit_limit) VALUES (?, ?, ?, ?)");
            stmt.setBigDecimal(1, customer.getCustNum());
            stmt.setString(2, customer.getCompany());
            stmt.setBigDecimal(3, customer.getCustRep());
            stmt.setBigDecimal(4, customer.getCreditLimit());
            return stmt;
        };
        return templOperation.templateOperationFromInterface(customer);
    }

    @Override
    public boolean updateWholeCustomer(Customers customer, BigDecimal cust_num) throws SQLException {
        TemplOperation<Customers> templOperation = (customers, conn) -> {
            PreparedStatement stmt = conn.prepareStatement("update customers set cust_num = ?, company = ?, cust_rep = ?,credit_limit = ? where cust_num = ?");
            stmt.setBigDecimal(1, customer.getCustNum());
            stmt.setString(2, customer.getCompany());
            stmt.setBigDecimal(3, customer.getCustRep());
            stmt.setBigDecimal(4, customer.getCreditLimit());
            stmt.setBigDecimal(5, cust_num);
            return stmt;
        };
        return templOperation.templateOperationFromInterface(customer);
    }

    @Override
    public boolean deleteAnotherCustomer(Customers customer) throws SQLException {
        TemplOperation<Customers> templOperation = (customers, conn) -> {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM customers where cust_num = ?");
            stmt.setBigDecimal(1, customer.getCustNum());
            return stmt;
        };
        return templOperation.templateOperationFromInterface(customer);
    }
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return null;
    }

    @Override
    public List<Customers> findCustomersByCreditLimit(BigDecimal creditLimit) throws SQLException {
        return null;
    }

    @Override
    public boolean insertCustomer(BigDecimal cust_num, BigDecimal credit_limit) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(BigDecimal cust_num) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteCustomer(BigDecimal cust_num) throws SQLException {
        return false;
    }

}
