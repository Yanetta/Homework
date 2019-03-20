package workSpringDataTest;

import JPAwork.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import workSpringData.config.DataConfig;
import workSpringData.repository.OrdersRepository;

import javax.transaction.Transactional;
import java.util.List;
import static org.junit.Assert.assertTrue;

@DirtiesContext
@ContextConfiguration(classes = DataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
public class OrderRepositoryIntegrationTest {
    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    public void testGetAllOrders(){
        List<Orders> orders = ordersRepository.findAll();
        System.out.println(orders);
        assertTrue(orders.size() > 15);
    }
}
