package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MateriaTest {

    public MateriaTest() {
    }

    @Test
    public void debeAgregarUnAlumno() {

        Materia m1 = new Materia();
        Alumno a1 = new Alumno("Nombre 1");

        m1.agregar(a1);

        var cantidadAlumnos = m1.getAlumnos().size();

         assertEquals("Error cantidad incorrecto", 
                    1,
                    cantidadAlumnos);
    }


    @Test
    public void debeAgregar30Alumnos() {

        Materia m1 = new Materia();
       
        for (int i = 1; i <= 30; i++) {
             Alumno a1 = new Alumno("Nombre 1");
             m1.agregar(a1);
        }

        var cantidadAlumnos = m1.getAlumnos().size();

         assertEquals("Error cantidad incorrecto", 
                    30,
                    cantidadAlumnos);
    }

}
