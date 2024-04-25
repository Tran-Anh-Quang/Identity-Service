package com.quangta.controller;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.request.UserUpdateRequest;
import com.quangta.dto.response.ApiResponse;
import com.quangta.entity.User;
import com.quangta.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<User> createUser(@RequestBody @Valid  UserCreationRequest request){
        ApiResponse<User> userApiResponse = new ApiResponse<>();

        userApiResponse.setResult(userService.createUser(request));
        userApiResponse.setMessage("Success");
        userApiResponse.setCode(200);
        
        return userApiResponse;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, null, 200);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, null, 200);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable String userId,
            @RequestBody UserUpdateRequest request
    ){
        User user = userService.updateUser(userId,request);
        return new ResponseEntity<>(user, null, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("Delete Success", null, HttpStatus.OK);
    }
}
