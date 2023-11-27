package com.capg.pizzapp.Controller;

import com.capg.pizzapp.Entity.Cart;
import com.capg.pizzapp.Entity.CartItem;
import com.capg.pizzapp.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cart")

public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("/createcart")
    public Cart createCart(@RequestBody Cart cart) {
        Cart savedcart = cartService.createCart(cart);
        return savedcart;
    }
    @GetMapping("/getCart/{cartId}")
    public Cart getCart(@PathVariable("cartId") int cartId){
        return cartService.getCart(cartId);
    }

    @PostMapping("/createcartitem")
    public CartItem createCartItem(@RequestBody CartItem cartItem){
        return cartService.createCartItem(cartItem);
    }
    @DeleteMapping("/deletecartitem")
    public CartItem deleteCartItem(@RequestBody CartItem cartItem){
        return cartService.createCartItem(cartItem);
    }
    @GetMapping("/getcartitem")
    public CartItem getCartItem(@RequestBody int cartItem){
        return cartService.getCartItem(cartItem);
    }
}
