package workwithJDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Set<Order> getAllOrders() throws SQLException {
        return null;
    }
    @Override
    public  Order findOrderById (BigDecimal id) throws SQLException {

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
            order.setMfr( rs.getString("mfr"));
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
