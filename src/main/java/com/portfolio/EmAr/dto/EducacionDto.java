package com.portfolio.EmAr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDto {

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
    public EducacionDto() {
    }

    public EducacionDto(String urllogoinst, String institucion, String fechainicio, String fechafin, String carrera, String tituloobtenido, String puntaje) {
        this.urllogoinst = urllogoinst;
        this.institucion = institucion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.carrera = carrera;
        this.tituloobtenido = tituloobtenido;
        this.puntaje = puntaje;
    }

}
