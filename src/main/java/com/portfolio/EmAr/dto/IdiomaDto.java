package com.portfolio.EmAr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdiomaDto {

    @NotNull
    private String nombre;

    @NotNull
    private String escritura;

    @NotNull
    private String lectura;

    @NotNull
    private String oralidad;

    //Constructores
    public IdiomaDto() {
    }

    public IdiomaDto(String nombre, String escritura, String lectura, String oralidad) {
        this.nombre = nombre;
        this.escritura = escritura;
        this.lectura = lectura;
        this.oralidad = oralidad;
    }

}
