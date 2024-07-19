package com.datashield.api.controller;

import com.datashield.api.entities.User;
import com.datashield.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam("username") String username,
                                      @RequestParam("password") String password) {
        try {
            User user = userService.connection(username, password);
            // Connexion réussie, renvoyer une réponse avec le statut 200 OK et l'objet User
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            // Identifiants invalides, renvoyer une réponse avec le statut 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
