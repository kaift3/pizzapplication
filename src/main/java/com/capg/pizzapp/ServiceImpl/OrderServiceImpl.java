package com.capg.pizzapp.ServiceImpl;

import com.capg.pizzapp.Entity.Order;
import com.capg.pizzapp.Repository.OrderRepository;
import com.capg.pizzapp.Service.OrderService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j @Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        log.info("Creating order...");
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(int orderId) {
        Optional<Order> orderByOrderId = Optional.ofNullable(orderRepository.findOrderByOrderId(orderId));
        if(!orderByOrderId.isPresent()){
            log.error("Order not found!");
            throw new IllegalStateException("Order with orderId " + orderId + " not found.");
        } else{
            log.info("Order {} found.", orderId);
            return orderRepository.findOrderByOrderId(orderId);
        }
    }

    @Override
    public List<Order> getOrders() {
        log.info("Fetching all Orders...");
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(int orderId) {
        Optional<Order> orderByOrderId = Optional.ofNullable(orderRepository.findOrderByOrderId(orderId));
        if(!orderByOrderId.isPresent()) {
            log.error("Order not found.");
            throw new IllegalStateException("Order with orderId " + orderId + " not found.");
        } else {
            log.info("Deleting order {}...", orderId);
            Order order = orderRepository.findOrderByOrderId(orderId);
            orderRepository.delete(order);
        }
    }
}
