package org.example.services;


import org.example.Repositories.UserRepository;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository usuarioRepository;

    public String verificarUsuario(User usuario) {
        if (usuarioRepository.existsByCorreoElectronico(usuario.getCorreoElectronico())) {
            return "Error: El usuario ya existe en la base de datos.";
        } else {
            usuarioRepository.save(usuario);
            return "Usuario guardado exitosamente.";
        }
       /* usuarioRepository.findByCorreoElectronico(usuario.getCorreoElectronico()).isPresent();
        if(optional.isPresent()){
            optional.get().getId_usuario();
        }
    }*/

    }
}


