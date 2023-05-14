package com.portfolio.EmAr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienciaDto {

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
    public ExperienciaDto() {
    }

    public ExperienciaDto(String urllogocomp, String fechainicio, String fechafin, String puesto, String compania, String descripciontrabajo) {
        this.urllogocomp = urllogocomp;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.puesto = puesto;
        this.compania = compania;
        this.descripciontrabajo = descripciontrabajo;
    }

}
