package com.datashield.api.service.implementation;

import com.datashield.api.entities.User;
import com.datashield.api.repository.UserRepo;
import com.datashield.api.service.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        user.setCreatedDate(Instant.now());
        return userRepo.save(user);
    }

    @Override
    public User connection(String username, String password) {
        User existingUser = userRepo.findByUsername(username);
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            // Connexion réussie, retourner l'utilisateur
            return existingUser;
        } else {
            // Identifiants invalides, renvoyer une exception ou une valeur null selon votre choix
            throw new IllegalArgumentException("Identifiants de connexion invalides");
        }
    }


}
