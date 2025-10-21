package com.mycompany.app;

import java.time.LocalDate;

public class FechaPersonalizada {

    private LocalDate fechaInterna;

    public FechaPersonalizada() {
        this.fechaInterna = LocalDate.now();
    }

    public LocalDate getFechaInterna() {
        return this.fechaInterna;
    }

    public void setFechaInterna(LocalDate valor) {
        this.fechaInterna = valor;
    }
}
