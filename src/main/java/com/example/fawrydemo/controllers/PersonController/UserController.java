package com.example.fawrydemo.controllers.PersonController;

import com.example.fawrydemo.services.PersonServices.UserService;
import com.example.fawrydemo.utils.Persons.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("users")
public class UserController {
    UserService userService = new UserService();

    @GetMapping("/list")
    public ResponseEntity<?> getAllUsers() { return userService.getAllUsers(); }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) { return userService.addUser(user); }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) { return userService.logIn(user); }
    @GetMapping("/signout")
    public ResponseEntity<?> signOut() { return userService.signOut(); }

}
