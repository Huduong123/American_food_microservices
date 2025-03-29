package com.american_food.api_ckt3.rest;


import com.american_food.api_ckt3.entity.User;
import com.american_food.api_ckt3.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system")
public class UserRestController {
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        user.setId(0);
        return userService.saveUser(user);
    }
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return user1;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "Delete success users has id= " + id;
    }
}
