package com.portfolio.EmAr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String urllogoinst;

    @NotNull
    private String institucion;

    @NotNull
    private String fechainicio;

    @NotNull
    private String fechafin;

    @NotNull
    private String carrera;

    @NotNull
    private String tituloobtenido;

    @NotNull
    private String puntaje;

    //Constructores
    public Educacion() {
    }

    public Educacion(String urllogoinst, String institucion, String fechainicio, String fechafin, String carrera, String tituloobtenido, String puntaje) {
        this.urllogoinst = urllogoinst;
        this.institucion = institucion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.carrera = carrera;
        this.tituloobtenido = tituloobtenido;
        this.puntaje = puntaje;
    }

}
