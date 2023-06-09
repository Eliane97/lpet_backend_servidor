package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Con libreria lombok puedo ahorra codigo de setters,getters y constructores
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Login {
    private String email;
    private String password;
}
