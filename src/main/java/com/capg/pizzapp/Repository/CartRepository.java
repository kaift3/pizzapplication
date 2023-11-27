package com.capg.pizzapp.Repository;

import com.capg.pizzapp.Entity.Cart;
import com.capg.pizzapp.Entity.CartItem;
import com.capg.pizzapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    //Cart saveByUser(User user);
    Optional<Cart> findByCartId(int id);
}
