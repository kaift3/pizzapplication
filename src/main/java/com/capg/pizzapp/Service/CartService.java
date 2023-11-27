package com.capg.pizzapp.Service;

import com.capg.pizzapp.Entity.Cart;
import com.capg.pizzapp.Entity.CartItem;

public interface CartService {
    public Cart createCart(Cart cart);
    public Cart getCart(int cartId);
    public CartItem getCartItem(int cartItemId);
    public CartItem createCartItem(CartItem cartItem);
}
