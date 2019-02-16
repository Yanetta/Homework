package workwithJDBC;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        Connection connection = Pool.getConnection();
        PreparedStatement stmt = connection.prepareStatement("Select * from orders");
        ResultSet rs = stmt.executeQuery();
        Set<Order> orders = new HashSet<>();
        while (rs.next()) {
            Order order = new Order();
            order.setAmount(rs.getBigDecimal("amount"));
            order.setQty(rs.getBigDecimal("qty"));
            order.setOrderNum(rs.getBigDecimal("order_num"));
            order.setOrderDate(rs.getDate("order_date"));
            order.setMfr(rs.getString("mfr"));

            PreparedStatement stmt1 = connection.prepareStatement("Select * from  products where product_id=?");
            stmt1.setString(1, rs.getString("product"));

            ResultSet innerrs = stmt1.executeQuery();
            while (innerrs.next()) {
                Product product = new Product();
                product.setProductID(innerrs.getString("product_Id"));
                product.setMfrID(innerrs.getString("mfr_Id"));
                product.setDescription(innerrs.getString("description"));
                product.setPrice(innerrs.getBigDecimal("price"));
                product.setQtyOnHand(innerrs.getBigDecimal("qty_On_Hand"));
                order.setProduct(product);
            }
            orders.add(order);
            innerrs.close();
            stmt1.close();
        }
        rs.close();
        stmt.close();
        connection.close();
        return orders;
    }

    @Override
    public Set<Order> getAllOrdersInnerJoin() throws SQLException {
        Connection connection = Pool.getConnection();
        PreparedStatement stmt = connection.prepareStatement("Select * from orders inner join products on orders.product = products.product_id");
        ResultSet rs = stmt.executeQuery();
        Set<Order> orders = new HashSet<>();
        while (rs.next()) {
            Order order = new Order();
            order.setAmount(rs.getBigDecimal("amount"));
            order.setQty(rs.getBigDecimal("qty"));
            order.setOrderNum(rs.getBigDecimal("order_num"));
            order.setOrderDate(rs.getDate("order_date"));
            order.setMfr(rs.getString("mfr"));

            Product product = new Product();
            product.setProductID(rs.getString("product_Id"));
            product.setMfrID(rs.getString("mfr_Id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setQtyOnHand(rs.getBigDecimal("qty_On_Hand"));
            order.setProduct(product);

            orders.add(order);
        }
        rs.close();
        stmt.close();
        connection.close();
        return orders;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {

        Connection connection = Pool.getConnection();
        PreparedStatement stmt = connection.prepareStatement("Select * from orders where order_num = ?");
        stmt.setBigDecimal(1, id);
        ResultSet rs = stmt.executeQuery();
        Order order = null;
        if (rs.next()) {
            order = new Order();
            order.setAmount(rs.getBigDecimal("amount"));
            order.setQty(rs.getBigDecimal("qty"));
            order.setOrderNum(rs.getBigDecimal("order_num"));
            order.setProduct(null);
            order.setOrderDate(rs.getDate("order_date"));
            order.setMfr(rs.getString("mfr"));
        }
        rs.close();
        stmt.close();
        connection.close();
        return order;
    }

    @Override
    public boolean insertOrder(BigDecimal orderNum, BigDecimal qty) throws SQLException {
        Connection connection = Pool.getConnection();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO orders (order_num, qty) VALUES (?, ?)");
        stmt.setBigDecimal(1, orderNum);
        stmt.setBigDecimal(2, qty);
        if (stmt.executeUpdate() > 0) {
            return true;
        }
        ;
        stmt.close();
        connection.close();
        return false;
    }


    @Override
    public boolean updateOrder(BigDecimal orderNum) throws SQLException {
        Connection connection = Pool.getConnection();
        PreparedStatement stmt = connection.prepareStatement("update orders set qty = 666 where order_num = ?");
        stmt.setBigDecimal(1, orderNum);
        stmt.executeUpdate();
        if (stmt.executeUpdate() > 0) {
            return true;
        }
        ;
        stmt.close();
        connection.close();
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal orderNum) throws SQLException {
        Connection connection = Pool.getConnection();
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM orders where order_num = ?");
        stmt.setBigDecimal(1,  orderNum);

        stmt.executeUpdate();
        if (stmt.executeUpdate() > 0) {
            return true;
        }
        ;
        stmt.close();
        connection.close();
        return false;
    }

    private void showMetaData(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int i = 1; i <= columnCount; ++i) {
            System.out.println("************");
            System.out.println("Column Name : " + resultSetMetaData.getColumnName(i));
            System.out.println("Column Type : " + resultSetMetaData.getColumnType(i));
            System.out.println("Column Class Name : " + resultSetMetaData.getColumnClassName(i));
            System.out.println("Column Type Name : " + resultSetMetaData.getColumnTypeName(i));
        }
    }
}
