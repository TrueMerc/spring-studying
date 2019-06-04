package ru.ryabtsev.spring.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.ryabtsev.spring.registration.UserRegistrationForm;
import ru.ryabtsev.spring.entities.User;

/**
 * Provides interface to user registration service.
 */
public interface UserService extends UserDetailsService {

    /**
     * Returns user object corresponding to given user name.
     * @param userName user name.
     * @return user object corresponding to given user name.
     */
    User findByUserName(final String userName);

    /**
     * Saves user data given from user registration form into repository.
     */
    void save(final UserRegistrationForm userRegistrationForm);
}
