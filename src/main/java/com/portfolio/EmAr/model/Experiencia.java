package com.portfolio.EmAr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String urllogocomp;

    @NotNull
    private String fechainicio;

    @NotNull
    private String fechafin;

    @NotNull
    private String puesto;

    @NotNull
    private String compania;

    @NotNull
    private String descripciontrabajo;

    //Constructores
    public Experiencia() {
    }

    public Experiencia(String urllogocomp, String fechainicio, String fechafin, String puesto, String compania, String descripciontrabajo) {
        this.urllogocomp = urllogocomp;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.puesto = puesto;
        this.compania = compania;
        this.descripciontrabajo = descripciontrabajo;
    }

}
