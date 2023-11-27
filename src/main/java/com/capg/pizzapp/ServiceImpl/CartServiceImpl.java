package com.capg.pizzapp.ServiceImpl;

import com.capg.pizzapp.Entity.Cart;
import com.capg.pizzapp.Entity.CartItem;
import com.capg.pizzapp.Repository.CartItemRepository;
import com.capg.pizzapp.Repository.CartRepository;
import com.capg.pizzapp.Repository.UserRepository;
import com.capg.pizzapp.Service.CartService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Cart createCart(Cart cart) {

        int userId = cart.getUser().getUserId();
        userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Cart savedCart = cartRepository.save(cart);

        return savedCart;
    }

    @Override
    public Cart getCart(int cartId) {
        Cart foundCart = cartRepository.findByCartId(cartId).get();
        //foundCart.setCartItem(cartItemRepository.findAllByCart(foundCart.getCartId()));
        return foundCart;
    }

    public CartItem getCartItem(int cartItemId){
        return cartItemRepository.findById(cartItemId).get();
    }
    public CartItem createCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }
}
