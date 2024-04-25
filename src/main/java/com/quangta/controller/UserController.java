package com.quangta.controller;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.request.UserUpdateRequest;
import com.quangta.dto.response.ApiResponse;
import com.quangta.dto.response.UserResponse;
import com.quangta.entity.User;
import com.quangta.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;

    @PostMapping("/create")
    public ApiResponse<User> createUser(@RequestBody @Valid  UserCreationRequest request){
        ApiResponse<User> userApiResponse = new ApiResponse<>();

        userApiResponse.setResult(userService.createUser(request));
        userApiResponse.setMessage("Success");
        userApiResponse.setCode(1000);

        return userApiResponse;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, null, 200);
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public UserResponse updateUser(
            @PathVariable String userId,
            @RequestBody UserUpdateRequest request
    ){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Delete Success", null, HttpStatus.OK);
    }
}
