package com.quangta.dto.request;

import com.quangta.validator.DobConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
     String username;
     String password;
     String lastName;
     String firstName;
     String email;

     @DobConstraint(min = 14, message = "INVALID_DOB")
     LocalDate dob;
     List<String> roles;
}
