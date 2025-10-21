package com.mycompany.app;

public class Auto
    implements IRegistrarAsistencia{

    @Override
    public String asistencia() {
        return "Asistencia registrada para el auto";
    }
}
