package JPAwork;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderDaoImpl implements OrderDao {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");

    }

    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public Set<Order> getAllOrders() throws SQLException {
        return null;
    }

    @Override
    public Set<Order> getAllOrdersInnerJoin() throws SQLException {
        return null;
    }

    @Override
    public Order findOrderById(BigDecimal id) throws SQLException {
        return null;
    }

    @Override

    public boolean insertOrder(Order transientInstance) {
        LOG.debug("persisting Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(transientInstance);
            entityManager.getTransaction().commit();
            LOG.debug("persist successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("persist failed", re);
            throw re;
        }
    }


    @Override
    public boolean updateOrder(BigDecimal orderNum) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal orderNum) throws SQLException {
        return false;
    }
}
