package com.example.springboot.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Model.Users;
import com.example.springboot.Repo.UserRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public String index() {
        return "Total Users: " + userRepo.count();
    }

    @GetMapping("/users/list")
    public ResponseEntity<Map<String, Object>> getUserAll() {
        Map<String, Object> response = new HashMap<>();

        List<Users> users = userRepo.findAll();

        response.put("status", "success");
        response.put("message", "User list retrieved successfully");
        response.put("data", users);

        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/users/save")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody Users user) {
        Map<String, Object> response = new HashMap<>();

        userRepo.save(user);

        response.put("status", "success");
        response.put("message", "User saved successfully");

        return ResponseEntity.ok(response);
    }
    
}
