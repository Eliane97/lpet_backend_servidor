package org.example.Repositories;


import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String nombre_usuario);

    List<User> findByEmail (String correo_electronico);


}
