package com.ordermanagement.service;

import com.ordermanagement.entity.Customer;
import com.ordermanagement.entity.Order;
import com.ordermanagement.entity.Payment;
import com.ordermanagement.repository.OrderRepository;

public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();

    public void createOrder(Customer customer, String description, double amount) {
        // Save the order along with the associated customer due to cascade
        Order order = new Order();
        order.setOrderDescription(description);
        order.setCustomer(customer);

        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setOrder(order);

        order.setPayment(payment);

        // Now save the order (this will also save the customer due to cascading)
        orderRepository.saveOrder(order);
        
        System.out.println("Order created and payment saved successfully!");
    }


}
