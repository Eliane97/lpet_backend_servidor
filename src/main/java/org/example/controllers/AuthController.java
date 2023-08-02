package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.UserAuthException;
import org.example.exceptions.UserRegistrationException;
import org.example.models.Login;
import org.example.models.User;
import org.example.models.responsemodels.ErrorResponse;
import org.example.models.responsemodels.LoginResponse;
import org.example.models.responsemodels.RegistrationResponse;
import org.example.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsersService usersService;

    public AuthController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registryUser(@RequestBody User user) {
        try {
            RegistrationResponse registrationResponse = usersService.registrarUsuario(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
        } catch (UserRegistrationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        try {
            LoginResponse loginResponse = usersService.login(login);
            return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
        } catch (UserAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(e.getMessage()));
        }
    }
}

