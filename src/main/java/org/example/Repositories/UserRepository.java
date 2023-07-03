package org.example.Repositories;


import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
