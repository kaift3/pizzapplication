package com.capg.pizzapp.Service;

import com.capg.pizzapp.Entity.Pizza;
import com.capg.pizzapp.Entity.User;

import java.util.List;

public interface PizzaService {
    public Pizza createPizza(Pizza pizza);
    public Pizza getPizza(int pizzaId);
    public List<Pizza> getPizzas();
    public void updatePizza(int pizzaId, String pizzaName, String pizzaDesc, String pizzaType, Double pizzaPrice);
    public void deletePizza(int pizzaId);
}
