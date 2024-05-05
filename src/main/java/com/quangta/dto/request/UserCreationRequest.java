package com.quangta.dto.request;

import java.time.LocalDate;

import com.quangta.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    Long id;

    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;

    String lastName;
    String firstName;
    String email;

    @Size(min = 10, message = "PHONE_NUMBER_INVALID")
    String phoneNumber;

    @DobConstraint(min = 14, message = "INVALID_DOB")
    LocalDate dob;
}
