package workSpringData.service;

import JPAwork.Orders;

import java.math.BigDecimal;
import java.util.Set;

public interface OrderService {
    Set<Orders> getAllOrders();
    void deleteOrder(BigDecimal id);
    public Orders findOrderById(BigDecimal id);


}
