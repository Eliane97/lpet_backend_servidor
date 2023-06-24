package org.example.services;


import org.example.Repositories.UserRepository;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository usuarioRepository;

    public String verificarUsuario(User usuario) {
        // Verificar si el usuario ya existe en la base de datos por su correo electrónico
        if (usuarioRepository.findByCorreoElectronico(usuario.getCorreoElectronico())) {
            return "Error: El usuario ya existe en la base de datos.";
        }
        else {
        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);
        return "Usuario guardado exitosamente.";}
    }

        }



