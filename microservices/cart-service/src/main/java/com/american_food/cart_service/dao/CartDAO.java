package com.american_food.cart_service.dao;

import com.american_food.cart_service.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository<CartItem, Integer> {

    // Lấy danh sách cart theouser
    List<CartItem> findByUserId(int userId);

    //kiểm tra 1 món ã có trong cart chưa
    CartItem findByUserIdAndFoodItemId(int userId, int foodItemId);

    //Xóa toàn bộ giỏ hàng theo user
    void deleteByUserId(int userId);

}
