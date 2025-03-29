package com.american_food.api_ckt3.dao;

import com.american_food.api_ckt3.entity.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUser(int id);
}
