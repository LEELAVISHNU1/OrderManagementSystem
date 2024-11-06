package com.ordermanagement;

import com.ordermanagement.entity.Customer;
import com.ordermanagement.service.OrderService;

public class MainApp {

    public static void main(String[] args) {
        // Create new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");

        // Create the OrderService
        OrderService orderService = new OrderService();

        // Create an order for the customer
        orderService.createOrder(customer, "Electronics Order", 100.0);

        // At this point, the order will be saved, and the related payment will also be saved
        System.out.println("Order created and payment saved successfully!");
    }
}
