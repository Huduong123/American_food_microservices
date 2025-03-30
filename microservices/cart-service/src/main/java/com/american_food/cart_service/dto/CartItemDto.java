package com.american_food.cart_service.dto;

public class CartItemDto {
    private int foodItemId;
    private String foodName;
    private String description;
    private  String imageUrl;
    private double price;
    private int quantity;
    private double totalPrice;
    public CartItemDto() {}

    public CartItemDto(int foodItemId, double totalPrice, int quantity, String imageUrl, String description, String foodName, double price) {
        this.foodItemId = foodItemId;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.description = description;
        this.foodName = foodName;
        this.price = price;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "foodItemId=" + foodItemId +
                ", foodName='" + foodName + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
