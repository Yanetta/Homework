package JPAwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;

public class CustomersDaoImpl implements CustomersDao {
    private static EntityManagerFactory factory;

    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }

    private static final Logger LOG = LogManager.getLogger(JPAwork.OrderDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();

    @Override
    public boolean insertCustomer(Customers customer) throws SQLException {

        LOG.debug("persisting Customers instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
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
    public boolean updateCustomer(Customers customer) throws SQLException {

        LOG.debug("updating Orders instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
            entityManager.getTransaction().commit();
            LOG.debug("update successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("update failed", re);
            throw re;
        }
    }


    @Override
    public boolean deleteCustomer(BigDecimal cust_num) throws SQLException {

        LOG.debug("removing Customers instance");
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(JPAwork.Customers.class, cust_num));
            entityManager.getTransaction().commit();
            LOG.debug("remove successful");
            return true;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("remove failed", re);
            throw re;
        }
    }
}
