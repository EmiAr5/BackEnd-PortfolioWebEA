package com.portfolio.EmAr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    @Size(max = 10)
    private String nombre;

    @NotNull
    @Size(max = 10)
    private String apellido;

    @NotNull
    @Size(max = 300)
    private String acercade;

    @NotNull
    private String fechanac;

    @NotNull
    private String celular;

    @NotNull
    private String email;

    @NotNull
    private String ocupacion;

    @NotNull
    private String paisresidencia;

    @NotNull
    private String urlfoto;

    @NotNull
    private String urlbanner;

    //Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String acercade, String fechanac, String celular, String email, String ocupacion, String paisresidencia, String urlfoto, String urlbanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercade = acercade;
        this.fechanac = fechanac;
        this.celular = celular;
        this.email = email;
        this.ocupacion = ocupacion;
        this.paisresidencia = paisresidencia;
        this.urlfoto = urlfoto;
        this.urlbanner = urlbanner;
    }

}
