package com.capg.pizzapp.Repository;

import com.capg.pizzapp.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderByOrderId(int orderId);
}
