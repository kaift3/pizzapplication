package com.capg.pizzapp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "pizza")
public class Pizza {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int pizzaId;

    @Column(nullable = true)
    private String pizzaName;

    @Column(nullable = true)
    private String pizzaDesc;

    @Column(nullable = true)
    private String pizzaType;

    @Column(nullable = true)
    private Double pizzaPrice;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

}