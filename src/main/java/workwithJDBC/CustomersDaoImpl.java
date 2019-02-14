package workwithJDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDaoImpl implements CustomersDao {

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        Connection connection = MakeConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement("Select * from customers");
        ResultSet rs = stmt.executeQuery();
        List<Customers> customers = new ArrayList<>();
        while (rs.next()) {
            Customers customer = new Customers();
            customer.setCustNum(rs.getBigDecimal("cust_num"));
            customer.setCustRep(rs.getBigDecimal("cust_rep"));
            customer.setCreditLimit(rs.getBigDecimal("credit_limit"));
            customer.setCompany(rs.getString("company"));
            customers.add(customer);
        }
        rs.close();
        stmt.close();
        connection.close();
        return customers;
    }

    @Override
    public List<Customers> findCustomersByCreditLimit(BigDecimal creditLimit) throws SQLException {
        Connection connection = MakeConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement("Select * from customers where credit_limit > ?");
        stmt.setBigDecimal(1, creditLimit);
        ResultSet rs = stmt.executeQuery();
        List<Customers> customers = new ArrayList<>();
        while (rs.next()) {
            Customers customer = new Customers();
            customer.setCustNum(rs.getBigDecimal("cust_num"));
            customer.setCustRep(rs.getBigDecimal("cust_rep"));
            customer.setCreditLimit(rs.getBigDecimal("credit_limit"));
            customer.setCompany(rs.getString("company"));
            customers.add(customer);
        }
        rs.close();
        stmt.close();
        connection.close();
        return customers;
    }
}
