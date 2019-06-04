package ru.ryabtsev.spring.registration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.ryabtsev.spring.validation.FieldMatch;
import ru.ryabtsev.spring.validation.ValidEmail;

import javax.validation.constraints.*;

/**
 * Implements user registration form.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class UserRegistrationForm extends RegistrationForm {

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 3, message = "username length must be greater than 2 symbols")
    private String userName;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    @Size(min=10, message = "is required")
    private String phone;

    @ValidEmail
    @NotNull(message = REQUIRED_FIELD_MESSAGE)
    private String email;

    @NotNull(message = "is required")
    private Long roleId;
}
