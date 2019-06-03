package ru.ryabtsev.spring.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ryabtsev.spring.validation.FieldMatch;
import ru.ryabtsev.spring.validation.ValidEmail;

import javax.validation.constraints.*;

/**
 * Implements user registration form.
 */
@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class UserRegistrationForm {

    @NotNull(message = "not null check")
    @Size(min = 3, message = "username length must be greater than 2 symbols")
    private String userName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @ValidEmail
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String email;
}
