package com.quangta.service;

import com.quangta.dto.request.UserCreationRequest;
import com.quangta.dto.response.UserResponse;
import com.quangta.entity.User;
import com.quangta.exception.AppException;
import com.quangta.exception.ErrorCode;
import com.quangta.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean // mock to user repository
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse response;
    private User user;

    @BeforeEach
    public void initData(){
        LocalDate dob = LocalDate.of(2000, 1, 1);

        request = UserCreationRequest.builder()
                .username("test02")
                .firstName("quang")
                .lastName("tran")
                .email("test02@gmail.com")
                .password("12345678")
                .dob(dob)
                .build();

        response = UserResponse.builder()
                .id("42e2-bae5-9ea7c0f1c4d4")
                .username("test02")
                .firstName("quang")
                .lastName("tran")
                .email("test02@gmail.com")
                .dob(dob)
                .build();

        user = User.builder()
                .id("42e2-bae5-9ea7c0f1c4d4")
                .username("test02")
                .firstName("quang")
                .lastName("tran")
                .email("test02@gmail.com")
                .dob(dob)
                .build();
    }

    @Test
    public void createUser_validRequest_success(){
        //GIVEN
        when(userRepository.existsByUsername(anyString())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);

        //WHEN
        var response = userService.createUser(request);

        //THEN
        Assertions.assertThat(response.getId()).isEqualTo("42e2-bae5-9ea7c0f1c4d4");
        Assertions.assertThat(response.getUsername()).isEqualTo("test02");
    }

    @Test
    public void createUser_userExisted_fail(){
        //GIVEN
        when(userRepository.existsByUsername(anyString())).thenReturn(true);

        //WHEN
        var exception = assertThrows(
                AppException.class,
                () -> userService.createUser(request)
        );

        //THEN
        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1001);
    }
}
