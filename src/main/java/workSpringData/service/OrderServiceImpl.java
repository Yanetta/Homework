package workSpringData.service;

import JPAwork.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import workSpringData.exeption.DeleteException;
import workSpringData.repository.OrdersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOG = LogManager.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrdersRepository ordersRepository;

    public Set<Orders> getAllOrders() {
        LOG.debug(" in getAllOrders method");
        HashSet<Orders> customersHashSet = new HashSet<Orders>(ordersRepository.findAll());
        return customersHashSet;
        // private OrdersRepository
    }

    @Override
    public Orders findOrderById(BigDecimal id) {
        System.out.println("?????????");
        return ordersRepository.findById(id).orElse(null);


    }

    @Override
    public void deleteOrder(BigDecimal id) {
        //   LOG.debug("delete")

    }


}

