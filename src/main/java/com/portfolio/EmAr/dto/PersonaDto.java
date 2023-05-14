package com.portfolio.EmAr.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {

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
    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String acercade, String fechanac, String celular, String email, String ocupacion, String paisresidencia, String urlfoto, String urlbanner) {
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
