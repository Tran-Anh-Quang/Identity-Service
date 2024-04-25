package com.quangta.service;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.request.UserUpdateRequest;
import com.quangta.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserCreationRequest request);

    List<User> getAllUsers();

    User getUserById(String userId);

    User updateUser(String userId, UserUpdateRequest request);

    void deleteUser(String userId);
}
