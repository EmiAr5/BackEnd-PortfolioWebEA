package com.portfolio.EmAr.controller;

import lombok.*;

@Getter
@Setter

//Clase que se implementrá para la devolución de mensajes.
public class Mensaje {

    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
