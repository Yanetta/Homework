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

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

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
        LOG.debug("getting all Order instanses");
        Set<Orders> allOrders = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from Orders");
            allOrders = new HashSet<>(query.getResultList());
        } catch (HibernateException hiException) {
            hiException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return allOrders;
    }

    @Override
    public Set<Orders> getAllOrdersInnerJoin() {
        return null;
    }

    @Override
    public Orders findOrderById(BigDecimal id) {
        LOG.debug("find Order instanses");
        Orders orders = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            orders = (Orders) sessionObj.load(Orders.class, id);
        } catch (HibernateException hiException) {
            hiException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
//        } finally {
//            if (sessionObj != null) {
//                sessionObj.close();
//            }
        }
        return orders;
    }

    @Override
    public boolean insertOrder(Orders order) {
        LOG.debug("insert Orders instanse");
        boolean isSuccessfull = false;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            Orders orders = new Orders();
            orders.setCustomers(order.getCustomers());
            orders.setMfr(order.getMfr());
            orders.setOrder_date(order.getOrder_date());
            orders.setOrder_num(order.getOrder_num());
            orders.setProducts(order.getProducts());
            orders.setQty(order.getQty());
            orders.setSalesreps(order.getSalesreps());
            orders.setAmount(order.getAmount());
            sessionObj.save(orders);
            sessionObj.getTransaction().commit();
            isSuccessfull = true;
        } catch (HibernateException hiException) {
            hiException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return isSuccessfull;
    }

    @Override
    public boolean updateOrder(Orders order) {
        LOG.debug("update Orders instanse");
        boolean isSuccessful = false;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            Orders orders = (Orders) sessionObj.load(Orders.class, order.getOrder_num());
            orders.setQty(order.getQty());
            sessionObj.getTransaction().commit();
           isSuccessful = true;
        } catch (HibernateException hiException) {
            hiException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return isSuccessful;

    }

    @Override
    public boolean deleteOrder(BigDecimal id) {
        LOG.debug("delete Orders instanse");
        boolean isSuccessfull = false;
        Orders orders = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            orders = (Orders) sessionObj.load(Orders.class, id);
            Query query = sessionObj.createQuery("DELETE FROM Orders WHERE order_num = :order_num");
            query.setParameter("order_num", id);
            sessionObj.delete(orders);
            sessionObj.getTransaction().commit();
            isSuccessfull = true;
        } catch (HibernateException hiException) {
            hiException.printStackTrace();
            if (null != sessionObj.getTransaction()) {
                LOG.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return isSuccessfull;
    }
}
