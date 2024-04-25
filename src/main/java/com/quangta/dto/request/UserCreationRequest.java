package com.quangta.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreationRequest {
    private Long id;

    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;

    private String lastName;
    private String firstName;
    private String email;
    private LocalDate dob;
}
