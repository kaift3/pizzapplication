package com.capg.pizzapp.Repository;

import com.capg.pizzapp.Entity.Cart;
import com.capg.pizzapp.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    //Cart saveByUser(User user);
    Optional<CartItem> findById(int id);
    List<CartItem> findAllByCart(Cart id);
}
