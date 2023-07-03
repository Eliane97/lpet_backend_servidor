package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo_electronico", nullable = false, length = 254)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 120)
    private String password;

    @Column(name = "nombre_usuario", nullable = false, length = 30)
    private String username;
}