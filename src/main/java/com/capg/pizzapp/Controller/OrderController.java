package com.capg.pizzapp.Controller;

import com.capg.pizzapp.Entity.Order;
import com.capg.pizzapp.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/order").toUriString());
        return ResponseEntity.created(uri).body(orderService.createOrder(order));
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") int orderId) {
        return ResponseEntity.ok().body(orderService.getOrder(orderId));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderId") int orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().body("Order deleted with orderId: " + orderId);
    }
}
