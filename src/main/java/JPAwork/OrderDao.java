package JPAwork;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

public interface OrderDao {
    Set<Orders> getAllOrders();

    Set<Orders> getAllOrdersInnerJoin();

    Orders findOrderById(BigDecimal id);

    boolean insertOrder(Orders order) ;

    boolean updateOrder(Orders order) ;

    boolean deleteOrder(BigDecimal id) ;
}
