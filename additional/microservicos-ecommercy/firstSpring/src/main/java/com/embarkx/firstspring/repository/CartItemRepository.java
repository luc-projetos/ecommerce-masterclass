package com.embarkx.firstspring.repository;

import com.embarkx.firstspring.model.CartItem;
import com.embarkx.firstspring.model.Product;
import com.embarkx.firstspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUserAndProduct(User user, Product product);
}
