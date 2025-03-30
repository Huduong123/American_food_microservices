package com.american_food.cart_service.services;

import com.american_food.cart_service.dao.CartDAO;
import com.american_food.cart_service.dto.CartItemDto;
import com.american_food.cart_service.entity.CartItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImp implements  CartService{
    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CartItemDto> getCartItemByUserId(int userId) {
        List<CartItem> cartItems = cartDAO.findByUserId(userId);
        List<CartItemDto> cartItemDtos = new ArrayList<>();

        for (CartItem item : cartItems) {
            // Gọi đến product-service (hoặc api-ckt3) để lấy thông tin sản phẩm
            Map<String, Object> product =
                    restTemplate.getForObject("http://api-ckt3/api/admin/products/" + item.getFoodItemId(), Map.class);

            if (product != null) {
                CartItemDto dto = new CartItemDto();
                dto.setFoodItemId(item.getFoodItemId());
                dto.setFoodName((String) product.get("name"));
                dto.setDescription((String) product.get("description"));
                dto.setImageUrl((String) product.get("image_url"));
                dto.setPrice(Double.parseDouble(product.get("price").toString()));
                dto.setQuantity(item.getQuantity());
                dto.setTotalPrice(dto.getPrice() * dto.getQuantity());

                cartItemDtos.add(dto);
            }
        }

        return cartItemDtos;
    }

    @Override
    @Transactional
    public void addToCart(int userId, int foodItemId, int quantity) {
        CartItem existingItem = cartDAO.findByUserIdAndFoodItemId(userId, foodItemId);
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            cartDAO.save(existingItem);
        }
        else {
            CartItem newItem = new CartItem();
            newItem.setFoodItemId(foodItemId);
            newItem.setQuantity(quantity);
            newItem.setUserId(userId);
            cartDAO.save(newItem);
        }
    }

    @Override
    @Transactional
    public void removeItem(int userId, int foodItemId) {
        CartItem existingItem = cartDAO.findByUserIdAndFoodItemId(userId, foodItemId);
        if (existingItem != null) {
            cartDAO.delete(existingItem);
        }
    }

    @Override
    public void clearCart(int userId) {
        cartDAO.deleteByUserId(userId);
    }
}
