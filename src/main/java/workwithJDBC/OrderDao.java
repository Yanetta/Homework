package workwithJDBC;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDao {
    Set<Order> getAllOrders() throws SQLException;

    Set<Order> getAllOrdersInnerJoin() throws SQLException;

    Order findOrderById(BigDecimal id) throws SQLException;

    boolean insertOrder(BigDecimal orderNum, BigDecimal qty) throws SQLException;

    boolean updateOrder(BigDecimal orderNum) throws SQLException;

    boolean deleteOrder(BigDecimal orderNum) throws SQLException;
}
