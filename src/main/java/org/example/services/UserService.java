package org.example.services;


import org.example.Repositories.UserRepository;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
    private UserRepository usuarioRepository ;

 public String registrarUsuario (User usuario){
    if (usuario.getId_usuario()==null) {
        usuarioRepository.save(usuario);
        return "Usuario guardado";
    }
    else {return "error, usuario existente no se pudo cargar el usuario, intente con otro";}
 }
}
