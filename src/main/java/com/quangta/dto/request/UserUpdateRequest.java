package com.quangta.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateRequest {
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private LocalDate dob;
}
