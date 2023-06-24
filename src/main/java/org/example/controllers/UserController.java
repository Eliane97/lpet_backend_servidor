package org.example.controllers;

import org.example.services.UserService;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api") // Ruta base para todos los endpoints en este controlador
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping ("/usuario")// url completa: http://localhost:8090/usuario
    public ResponseEntity<String> registrarUsuario(@RequestBody User usuario) {
        String respuesta = service.verificarUsuario(usuario);
        if (respuesta.contains("Error")) {
           return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }
       else {
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);}
    }

/*
    @GetMapping ("/usuario")// url completa: http://localhost:8090/usuario
    public String hola (){
     return "Hola";
    }
*/
}
