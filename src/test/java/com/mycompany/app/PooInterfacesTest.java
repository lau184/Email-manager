package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PooInterfacesTest {

    @Test
    public void interfaceTest1() {

        Profesor profesor1 = new Profesor("Profesor 1");
        
        assertEquals("DEbe dar clases",
                "El profesor esta dando clase",
                profesor1.darClase());

    }


    @Test
    public void tomarAsistenciaProfesorTest() {

        AsistenciaManager am1 = new AsistenciaManager();

         Profesor profesor1 = new Profesor("Profesor 1");
        am1.tomarAsistencia(profesor1);
        
        assertEquals("DEbe tomas asistencia",
                1,
                am1.getAsistencias());

    }


    @Test
    public void tomarAsistenciaAlumnoTest() {

        AsistenciaManager am1 = new AsistenciaManager();

         Alumno alumno1 = new Alumno("Nombre 1");
        am1.tomarAsistencia(alumno1);
        
        assertEquals("DEbe tomas asistencia",
                1,
                am1.getAsistencias());

    }

    @Test
    public void tomarAsistenciaAutoTest() {

        AsistenciaManager am1 = new AsistenciaManager();

         Auto auto1 = new Auto();
        am1.tomarAsistencia(auto1);
        
        assertEquals("DEbe tomas asistencia",
                1,
                am1.getAsistencias());

    }
}
