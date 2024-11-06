package com.ordermanagement.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ordermanagement.entity.Customer;
import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.Payment;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // Load Hibernate configuration
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Payment.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
