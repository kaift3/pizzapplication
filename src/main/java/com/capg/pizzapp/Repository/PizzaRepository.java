package com.capg.pizzapp.Repository;

import com.capg.pizzapp.Entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    Pizza findPizzaByPizzaId(int pizzaId);
}
