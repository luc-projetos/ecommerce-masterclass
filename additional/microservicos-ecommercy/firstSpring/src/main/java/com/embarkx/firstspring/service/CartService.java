package com.embarkx.firstspring.service;

import com.embarkx.firstspring.dto.CartItemRequest;
import com.embarkx.firstspring.model.CartItem;
import com.embarkx.firstspring.model.Product;
import com.embarkx.firstspring.model.User;
import com.embarkx.firstspring.repository.CartItemRepository;
import com.embarkx.firstspring.repository.ProductRepository;
import com.embarkx.firstspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;

    public boolean addToCart(String userId, CartItemRequest request) {

        //Look for product
        Optional<Product> productOpt = productRepository.findById(request.getProductId());
        if(productOpt.isEmpty()){
            return false;
        }

        Product product = productOpt.get();
        if(product.getStockQuantity() < request.getQuantity()){
            return false;
        }

        Optional<User> userOpt = userRepository.findById(Long.valueOf(userId));
        if(userOpt.isEmpty()){
            return false;
        }

        User user = userOpt.get();

        CartItem existingCarItem = cartItemRepository.findByUserAndProduct(user, product);
        if(existingCarItem != null){
            //Update the quantity
            existingCarItem.setQuantity(existingCarItem.getQuantity() + request.getQuantity());
            existingCarItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(existingCarItem.getQuantity())));
            cartItemRepository.save(existingCarItem);
        }else{
            CartItem cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity())));
            cartItemRepository.save(cartItem);
        }

        return true;
    }
}
