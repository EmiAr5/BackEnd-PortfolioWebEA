package com.portfolio.EmAr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String enlace;

    @NotNull
    private String urlimagen;

    @NotNull
    private String nombre;

    @NotNull
    private String fechainicio;

    @NotNull
    private String fechafin;

    @NotNull
    private String descripcion;

    //Constructores
    public Proyecto() {
    }

    public Proyecto(String enlace, String urlimagen, String nombre, String fechainicio, String fechafin, String descripcion) {
        this.enlace = enlace;
        this.urlimagen = urlimagen;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
    }

}
