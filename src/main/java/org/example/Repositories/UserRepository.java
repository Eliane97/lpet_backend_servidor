package org.example.Repositories;


import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByCorreoElectronico(String correoElectronico);
    Optional<User> findByCorreoElectronico(String correoElectronico);
/*

    boolean existsByNombreUsuario(String nombreUsuario);



*/
}

