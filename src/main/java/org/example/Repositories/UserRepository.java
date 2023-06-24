package org.example.Repositories;


import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM User e WHERE e.correoElectronico = :valor")
    boolean findByCorreoElectronico(@Param("valor")String correoElectronico);

/*

    boolean existsByNombreUsuario(String nombreUsuario);



*/
}

