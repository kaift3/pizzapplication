package com.capg.pizzapp.Controller;

import com.capg.pizzapp.Entity.Pizza;
import com.capg.pizzapp.Form.Forms;
import com.capg.pizzapp.Service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("")
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/pizza").toUriString());
        return ResponseEntity.created(uri).body(pizzaService.createPizza(pizza));
    }

    @GetMapping("")
    public ResponseEntity<List<Pizza>> getPizzas() {
        return ResponseEntity.ok().body(pizzaService.getPizzas());
    }

    @GetMapping("/{pizzaId}")
    public ResponseEntity<Pizza> getPizza(@PathVariable("pizzaId") int pizzaId) {
        return ResponseEntity.ok().body(pizzaService.getPizza(pizzaId));
    }

    //    Update Pizza
    @PutMapping("/{pizzaId}")
    public ResponseEntity<String> updatePizza(@PathVariable("pizzaId") int pizzaId, @RequestBody Forms.UpdatePizzaForm form) {
        pizzaService.updatePizza(pizzaId, form.getPizzaName(), form.getPizzaDesc(), form.getPizzaType(), form.getPizzaPrice());
        return ResponseEntity.ok().body("Pizza " + pizzaId + " updated.");
    }

    //    Delete Pizza with pizzaId
    @DeleteMapping("/{pizzaId}")
    public ResponseEntity<?> deletePizza(@PathVariable("pizzaId") int pizzaId) {
        pizzaService.deletePizza(pizzaId);
        return ResponseEntity.ok().body("Pizza deleted with pizzaId: " + pizzaId);
    }
}
