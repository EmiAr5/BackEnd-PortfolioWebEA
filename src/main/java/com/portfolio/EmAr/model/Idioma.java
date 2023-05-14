package com.portfolio.EmAr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String escritura;

    @NotNull
    private String lectura;

    @NotNull
    private String oralidad;

    //Constructores
    public Idioma() {
    }

    public Idioma(String nombre, String escritura, String lectura, String oralidad) {
        this.nombre = nombre;
        this.escritura = escritura;
        this.lectura = lectura;
        this.oralidad = oralidad;
    }

}
