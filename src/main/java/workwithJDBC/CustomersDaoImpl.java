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


    @Override
    public boolean insertCustomer(BigDecimal cust_num, BigDecimal credit_limit) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isRowInserted = false;
        try {
            connection = Pool.getConnection();
            stmt = connection.prepareStatement("INSERT INTO customers (cust_num, credit_limit) VALUES (?, ?)");
            stmt.setBigDecimal(1, cust_num);
            stmt.setBigDecimal(2, credit_limit);
            isRowInserted = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRowInserted;

    }

    @Override
    public boolean insertWholeCustomer(Customers customer) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isRowInserted = false;
        try {
            connection = Pool.getConnection();
            stmt = connection.prepareStatement("INSERT INTO customers (cust_num, company, cust_rep, credit_limit) VALUES (?, ?, ?, ?)");
            stmt.setBigDecimal(1, customer.getCustNum());
            stmt.setString(2, customer.getCompany());
            stmt.setBigDecimal(3, customer.getCustRep());
            stmt.setBigDecimal(4, customer.getCreditLimit());
            isRowInserted = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRowInserted;

    }


    @Override
    public boolean updateCustomer(BigDecimal cust_num) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isRowUpdated = false;
        try {
            connection = Pool.getConnection();
            stmt = connection.prepareStatement("update customers set credit_limit = 888 where cust_num = ?");
            stmt.setBigDecimal(1, cust_num);
            isRowUpdated = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRowUpdated;
    }

    @Override
    public boolean updateWholeCustomer(Customers customer, BigDecimal cust_num) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isRowUpdated = false;
        try {
            connection = Pool.getConnection();
            stmt = connection.prepareStatement("update customers set cust_num = ?, company = ?, cust_rep = ?,credit_limit = ? where cust_num = ?");
            stmt.setBigDecimal(1, customer.getCustNum());
            stmt.setString(2, customer.getCompany());
            stmt.setBigDecimal(3, customer.getCustRep());
            stmt.setBigDecimal(4, customer.getCreditLimit());
            stmt.setBigDecimal(5, cust_num);

            isRowUpdated = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRowUpdated;
    }

    @Override
    public boolean deleteCustomer(BigDecimal cust_num) {
        Connection connection = null;
        PreparedStatement stmt = null;
        Boolean isRowDeleted = false;
        try {
            connection = Pool.getConnection();

            stmt = connection.prepareStatement("DELETE FROM customers where cust_num = ?");
            stmt.setBigDecimal(1, cust_num);

            isRowDeleted = stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isRowDeleted;
    }


   
}
