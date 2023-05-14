package com.portfolio.EmAr.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SoftskillDto {

    @NotNull
    private String nombre;

    @NotNull
    private Integer porcentaje;
    
    //Constructores
    public SoftskillDto() {
    }

    public SoftskillDto(String nombre, Integer porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

}
