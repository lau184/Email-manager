package com.mycompany.app;

public class AsistenciaManager {

    private int asistenciasCantidad = 0;
    //public void tomarAsistencia(Persona persona) {
    //}

    public void tomarAsistencia(IRegistrarAsistencia algoQueRegistrarAsistencia) {
       algoQueRegistrarAsistencia.asistencia();
       asistenciasCantidad++;
    }

    public int getAsistencias() {
        return this.asistenciasCantidad;
    }

}
