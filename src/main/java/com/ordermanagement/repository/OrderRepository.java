package com.ordermanagement.repository;

import com.ordermanagement.config.HibernateUtil;
import com.ordermanagement.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderRepository {

    public void saveOrder(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(order);  // Save the order to the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
