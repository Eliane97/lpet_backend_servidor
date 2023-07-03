package org.example.controllers;

import org.example.exceptions.UserAuthException;
import org.example.exceptions.UserRegistrationException;
import org.example.models.Login;
import org.example.models.User;
import org.example.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registryUser(@RequestBody User user) {
        try {
            usersService.registrarUsuario(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
        } catch (UserRegistrationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        try {
            usersService.login(login);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario logueado correctamente");
        } catch (UserAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

