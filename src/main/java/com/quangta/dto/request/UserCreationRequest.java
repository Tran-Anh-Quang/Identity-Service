package com.quangta.dto.request;

import java.time.LocalDate;

import com.quangta.validator.DobConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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

    // the password must contain:
    // at least 8 characters
    // a lower case
    // an upper case
    // a special character
    // a digit
    @Size(min = 8, message = "PASSWORD_INVALID_1")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "PASSWORD_INVALID_2")
    String password;

    @Size(min = 3, message = "LAST_NAME_INVALID")
    String lastName;

    @Size(min = 3, message = "FIRST_NAME_INVALID")
    String firstName;

    // the email (RFC5322) does not contain:
    // (|) and (') characters
    @Email(message = "EMAIL_INVALID", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    String email;

    @Size(min = 10, max = 10, message = "PHONE_NUMBER_INVALID")
    String phoneNumber;

    @DobConstraint(min = 14, message = "INVALID_DOB")
    LocalDate dob;
}
