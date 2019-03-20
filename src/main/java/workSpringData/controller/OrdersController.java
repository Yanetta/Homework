package workSpringData.controller;

import JPAwork.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import workSpringData.service.OrderService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private static final Logger LOG = LogManager.getLogger(OrdersController.class);
    @Autowired
    private OrderService orderService;
    @GetMapping("/{id}")
    public @ResponseBody
    Orders getOrderById(@PathVariable("id") int id) {
        return orderService.findOrderById(BigDecimal.valueOf(id));

    }
}
