package com.capg.pizzapp.ServiceImpl;

import com.capg.pizzapp.Entity.Pizza;
import com.capg.pizzapp.Repository.PizzaRepository;
import com.capg.pizzapp.Service.PizzaService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Slf4j @Transactional
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza createPizza(Pizza pizza) {
        log.info("Creating pizza...");
        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza getPizza(int pizzaId) {
        Optional<Pizza> pizzaByPizzaId = Optional.ofNullable(pizzaRepository.findPizzaByPizzaId(pizzaId));
        if(!pizzaByPizzaId.isPresent()) {
            log.error("Pizza not found!");
            throw new IllegalStateException("Pizza with pizzaId " + pizzaId + " not found.");
        } else{
            log.info("Pizza {} found.", pizzaId);
            return pizzaRepository.findPizzaByPizzaId(pizzaId);
        }
    }

    @Override
    public List<Pizza> getPizzas() {
        log.info("Fetching all pizzas...");
        return pizzaRepository.findAll();
    }

    @Override @Transactional
    public void updatePizza(int pizzaId, String pizzaName, String pizzaDesc, String pizzaType, Double pizzaPrice) {
        Optional<Pizza> pizzaByPizzaId = Optional.ofNullable(pizzaRepository.findPizzaByPizzaId(pizzaId));
        if(!pizzaByPizzaId.isPresent()) {
            log.info("Pizza not found!");
            throw new IllegalStateException("Pizza with pizzaId " + pizzaId + " not found.");
        } else{
            log.info("Updating pizza {}", pizzaId);
            Pizza pizza = pizzaRepository.findPizzaByPizzaId(pizzaId);
            pizza.setPizzaName(pizzaName);
            pizza.setPizzaDesc(pizzaDesc);
            pizza.setPizzaType(pizzaType);
            pizza.setPizzaPrice(pizzaPrice);
        }
    }

    @Override
    public void deletePizza(int pizzaId) {
        Optional<Pizza> pizzaByPizzaId = Optional.ofNullable(pizzaRepository.findPizzaByPizzaId(pizzaId));
        if(!pizzaByPizzaId.isPresent()) {
            log.error("Pizza not found.");
            throw new IllegalStateException("Pizza with pizzaId " + pizzaId + " not found.");
        } else{
            log.info("Deleting pizza {}...", pizzaId);
            Pizza pizza = pizzaRepository.findPizzaByPizzaId(pizzaId);
            pizzaRepository.delete(pizza);
        }
    }
}
