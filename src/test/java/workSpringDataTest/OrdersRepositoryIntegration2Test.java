package workSpringDataTest;

import JPAwork.Orders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import workSpringData.config.DataConfig;
import workSpringData.repository.OrdersRepository;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertTrue;

@DirtiesContext
@ContextConfiguration(classes = DataConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class OrdersRepositoryIntegration2Test {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testGetAllOrders() {
        List<Orders> orders = ordersRepository.findAll();
        System.out.println(orders);
        assertTrue(orders.size() > 1);
    }

    @Before
    public void initDb() {
        Resource initSchema = new ClassPathResource("schema.sql");
        Resource data = new ClassPathResource("data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, data);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
    }
}


