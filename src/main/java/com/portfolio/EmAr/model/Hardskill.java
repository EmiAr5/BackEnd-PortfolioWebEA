package com.portfolio.EmAr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Hardskill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private Integer porcentaje;

    //Constructores
    public Hardskill() {
    }

    public Hardskill(String nombre, Integer porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

}
