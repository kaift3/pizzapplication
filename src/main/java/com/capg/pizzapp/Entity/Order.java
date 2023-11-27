package com.capg.pizzapp.Entity;

import com.capg.pizzapp.Util.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int orderId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(nullable = true)
    private String customerName;

    @Column(nullable = true)
    private String customerAddress;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = true)
    private String orderDate = DateTime.getCurrentDateTimeString();

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Pizza> pizzas = new ArrayList<>();
}
