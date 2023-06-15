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
    private Long id_usuario;

    @Column(name = "correo_electronico ", nullable = false, length = 254 )
    private String correo_electronico;

    @Column(name = "contrasena", nullable = false,length = 120)
    private String contrasena;

    @Column(name = "nombre_usuario",nullable = false,length = 30)
    private String nombre_usuario;


/*
        @Column(nullable = false)
        private Timestamp fecha_alta_usuarios;

        @Column(nullable = false)
        private Boolean activo;*/


}