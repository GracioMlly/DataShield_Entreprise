package com.datashield.api.service;

import com.datashield.api.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);

    User createUser(User user);

    User connection(String username, String password);
}
