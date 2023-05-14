package com.portfolio.EmAr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectoDto {

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
    public ProyectoDto() {
    }

    public ProyectoDto(String enlace, String urlimagen, String nombre, String fechainicio, String fechafin, String descripcion) {
        this.enlace = enlace;
        this.urlimagen = urlimagen;
        this.nombre = nombre;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
    }

}
