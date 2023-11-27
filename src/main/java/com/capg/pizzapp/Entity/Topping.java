package com.capg.pizzapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "topping")
public class Topping {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int toppingId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double cost;
}
