package com.american_food.cart_service.services;

import com.american_food.cart_service.dto.CartItemDto;

import java.util.List;

public interface CartService {

    //Lấy danh sách sản phẩm trong giỏ hàng của user
    List<CartItemDto> getCartItemByUserId(int userId);

    //Thêm hoặc cập nhật sản phẩm vào giỏ hàng
    void addToCart(int userId, int foodItemId, int quantity);

    void removeItem(int userId, int foodItemId);

    void clearCart(int userId);
}
