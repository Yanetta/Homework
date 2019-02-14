package workwithJDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        Connection connection = MakeConnection.getConnection();
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
        Connection connection = MakeConnection.getConnection();
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

    //Написати реалызацыю getAllOrders з продуктами через два селекта і через джоін (одним селектом) (edited)
//    Парні в списку - модель таблиці Сustomers
//    зробить селект всіх і по якомусь полю декількох
//    ревьюрер +3
    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {

        Connection connection = MakeConnection.getConnection();
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
    public boolean insertOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) throws SQLException {
        return false;
    }

}
