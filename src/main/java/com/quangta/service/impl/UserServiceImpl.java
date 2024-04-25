package com.quangta.service.impl;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.request.UserUpdateRequest;
import com.quangta.entity.User;
import com.quangta.exception.AppException;
import com.quangta.exception.ErrorCode;
import com.quangta.repository.UserRepository;
import com.quangta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    @Override
    public User updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).get();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
