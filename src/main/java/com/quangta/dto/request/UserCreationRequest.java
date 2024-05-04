package com.quangta.dto.request;

import com.quangta.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

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

     @DobConstraint(min = 14, message = "INVALID_DOB")
     LocalDate dob;
}
