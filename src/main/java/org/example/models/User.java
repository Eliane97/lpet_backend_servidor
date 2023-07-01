package org.example.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idUsuario")
    private Long idUsuario;

    @Column(name="correoElectronico", nullable = false, length = 254 )
    private String correoElectronico;

    @Column(name="contrasena", nullable = false,length = 120)
    private String contrasena;

    @Column(name ="nombreUsurio",nullable = false,length = 30)
    private String nombreUsuario;


/*
        @Column(nullable = false)
        private Timestamp fecha_alta_usuarios;

        @Column(nullable = false)
        private Boolean activo;*/

}