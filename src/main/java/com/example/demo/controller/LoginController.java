package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin()
public class LoginController {
    private UserService userService;
    private AuthorityService authorityService;

    private UserRepository userRepository;
    @Autowired
    public LoginController(UserService userService, AuthorityService authorityService, UserRepository userRepository) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String saveUser(@RequestBody LoginDto userDto){
        userService.saveUser(userDto.getUsers());
        authorityService.saveUser(userDto.getAuthority());
        return "Registered";
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users userData) {
        Users user = userRepository.findByEmail(userData.getEmail());
        if (user != null && user.getPassword().equals(userData.getPassword())) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.badRequest().body("Invalid username or password");
    }


}
