package ru.ryabtsev.spring.registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ryabtsev.spring.validation.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Implements student registration form.
 */
@Data
@NoArgsConstructor
public class StudentRegistrationForm {

    private static final String REQUIRED_FIELD_MESSAGE = "This field is required.";

    @NotNull(message=REQUIRED_FIELD_MESSAGE)
    @Size(min=2, message="First name should contains at least two symbols.")
    private String firstName;

    @NotNull(message=REQUIRED_FIELD_MESSAGE)
    @Size(min=1, message="Last name should contains at least one symbol.")
    private String lastName;

    @NotNull(message=REQUIRED_FIELD_MESSAGE)
    @Size(min=10, message="International phone number format requires at least 10 symbols")
    private String phoneNumber;

    @ValidEmail
    @NotNull(message=REQUIRED_FIELD_MESSAGE)
    private String email;
}
