package com.capg.pizzapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "cartitem")
public class CartItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int Id;

    @Column(nullable = true)
    private String pizzaId;

    @Column(nullable = true)
    private String cartType;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}