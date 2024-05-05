package com.quangta.service;

import java.util.List;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.request.UserUpdateRequest;
import com.quangta.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserCreationRequest request);

    UserResponse getProfile();

    List<UserResponse> getAllUsers();

    UserResponse getUserById(String userId);

    UserResponse updateUser(String userId, UserUpdateRequest request);

    void deleteUser(String userId);
}
