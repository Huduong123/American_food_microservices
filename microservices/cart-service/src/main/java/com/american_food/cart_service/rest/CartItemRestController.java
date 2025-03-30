package com.american_food.cart_service.rest;

import com.american_food.cart_service.dto.CartItemDto;
import com.american_food.cart_service.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/cart")
public class CartItemRestController {

    @Autowired
    private CartService cartService;

    // Lấy danh sách sản phẩm trong giỏ hàng của 1 user
    @GetMapping("/{userId}")
    public List<CartItemDto> getCartByUserId(@PathVariable int userId) {
        return cartService.getCartItemByUserId(userId);
    }

    // Thêm sản phẩm vào giỏ
    @PostMapping("/add")
    public void addToCart(@RequestParam int userId,
                          @RequestParam int foodItemId,
                          @RequestParam int quantity) {
        cartService.addToCart(userId, foodItemId, quantity);
    }

    // Xoá 1 sản phẩm khỏi giỏ
    @DeleteMapping("/remove")
    public void removeItem(@RequestParam int userId,
                           @RequestParam int foodItemId) {
        cartService.removeItem(userId, foodItemId);
    }

    // Xoá toàn bộ giỏ hàng
    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable int userId) {
        cartService.clearCart(userId);
    }
}
