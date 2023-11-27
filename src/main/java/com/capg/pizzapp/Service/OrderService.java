package com.capg.pizzapp.Service;

import com.capg.pizzapp.Entity.Order;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);
    public Order getOrder(int orderId);
    public List<Order> getOrders();
    public void deleteOrder(int orderId);
}
