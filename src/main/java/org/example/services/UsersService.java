package org.example.services;

import org.example.Repositories.UserRepository;
import org.example.exceptions.UserAuthException;
import org.example.models.Login;
import org.example.models.User;
import org.example.models.responsemodels.LoginResponse;
import org.example.models.responsemodels.RegistrationResponse;
import org.example.validations.UserValidations;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UserRepository userRepository;
    private final UserValidations userValidations;

    public UsersService(UserRepository userRepository, UserValidations userValidations) {
        this.userRepository = userRepository;
        this.userValidations = userValidations;
    }

    public RegistrationResponse registrarUsuario(User usuario) {
        userValidations.validateExistingUser(usuario.getEmail());
        User savedUser = userRepository.save(usuario);
        return new RegistrationResponse(savedUser.getEmail(), savedUser.getUsername());
    }


    public LoginResponse login(Login login) {
        User usuarioDB = userRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new UserAuthException("Usuario no encontrado"));

        if (usuarioDB.getPassword().equals(login.getPassword())) {
            return new LoginResponse(usuarioDB.getId(), usuarioDB.getEmail(), usuarioDB.getUsername());
        } else {
            throw new UserAuthException("Usuario o contraseña incorrectos");
        }
    }
}
