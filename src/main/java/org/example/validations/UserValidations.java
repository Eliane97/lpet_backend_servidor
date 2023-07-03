package org.example.validations;

import org.example.Repositories.UserRepository;
import org.example.exceptions.UserRegistrationException;

public class UserValidations {
    private final UserRepository userRepository;

    public UserValidations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateExistingUser(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserRegistrationException("El email ya está registrado");
        }
    }
}