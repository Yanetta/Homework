package JPAwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

public class ProductsDaoImpl implements ProductsDao {
    private static EntityManagerFactory factory;
    static {
        Locale.setDefault(Locale.ENGLISH);
        factory = Persistence.createEntityManagerFactory("PERSISTENCE");
    }
    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);
    private EntityManager entityManager = factory.createEntityManager();
    @Override
    public Set<Products> getAllProducts() {
        return null;
    }

    @Override
    public Products findProductsrById(String id) {

        LOG.debug("find Products instance");
        try {
            entityManager.getTransaction().begin();
            Products instance = entityManager.find(Products.class, id);
            entityManager.getTransaction().commit();
            LOG.debug("find successful");
            return instance;
        } catch (RuntimeException re) {
            if (entityManager != null) {
                System.out.println("Transaction is being rolled back.");
                entityManager.getTransaction().rollback();
            }
            LOG.error("find failed", re);
            throw re;
        }
    }

    @Override
    public boolean insertProducts(Products products) {
        return false;
    }

    @Override
    public boolean updateProducts(Products products) {
        return false;
    }

    @Override
    public boolean deleteProducts(BigDecimal id) {
        return false;
    }
}
