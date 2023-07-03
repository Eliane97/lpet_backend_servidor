package org.example.services;

import org.example.Repositories.UserRepository;
import org.example.exceptions.UserAuthException;
import org.example.models.Login;
import org.example.models.User;
import org.example.validations.UserValidations;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UserRepository userRepository;
    private final UserValidations userValidations;

    public UsersService(UserRepository usuarioRepository, UserValidations userValidations) {
        this.userRepository = usuarioRepository;
        this.userValidations = userValidations;
    }

    public void registrarUsuario(User usuario) {
        userValidations.validateExistingUser(usuario.getEmail());

        userRepository.save(usuario);
    }

    private boolean autenticarUsuario(Login login) {
        User usuarioDB = userRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new UserAuthException("Usuario no encontrado"));

        return usuarioDB.getPassword().equals(login.getPassword());
    }

    public void login(Login login) {
        if (autenticarUsuario(login)) {
            User usuarioDB = userRepository.findByEmail(login.getEmail())
                    .orElseThrow(() -> new UserAuthException("Usuario no encontrado"));
        } else {
            throw new UserAuthException("Usuario o contraseña incorrectos");
        }
    }
}