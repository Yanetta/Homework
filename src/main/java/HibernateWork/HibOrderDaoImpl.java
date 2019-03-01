package HibernateWork;
import JPAwork.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.io.File;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

public class HibOrderDaoImpl implements OrderDao {
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);
    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(Orders.class);
        configObj.addAnnotatedClass(Customers.class);
        configObj.addAnnotatedClass(Offices.class);
        configObj.addAnnotatedClass(Products.class);
        configObj.addAnnotatedClass(Salesreps.class);
        configObj.configure(new File("src\\main\\resources\\hibernate.cfg.xml"));
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }

    @Override
    public Set<Orders> getAllOrders() {
        return null;
    }

    @Override
    public Set<Orders> getAllOrdersInnerJoin() {
        return null;
    }

    @Override
    public Orders findOrderById(BigDecimal id) {
        Orders orders = null;
        try{
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            orders = (Orders) sessionObj.load(Orders.class, id);
        } catch ( HibernateException sqlException){
            sqlException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }

        }
        return orders;
    }


    @Override
    public boolean insertOrder(Orders order) {
        return false;
    }

    @Override
    public boolean updateOrder(Orders order) {
        return false;
    }

    @Override
    public boolean deleteOrder(BigDecimal id) {
        return false;
    }
}
