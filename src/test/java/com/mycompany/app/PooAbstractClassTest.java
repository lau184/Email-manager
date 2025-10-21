package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PooAbstractClassTest {

     @Test
    public void testPersona1() {

        //Persona persona1 = new Persona();
        Persona persona1 = new Alumno("Nombre 1");
        persona1.setNombre("Nombre Alumno 1");
        
        assertEquals("Nombre",
                "Nombre Alumno 1",
                persona1.getNombre());

    }


     @Test
    public void noPermitirAlumnoSinNombre() {

        Persona persona1 = new Alumno("Nombre Alumnos 1");
        //persona1.setNombre("Nombre Alumno 1");
        
        assertNotNull(persona1.getNombre());

        assertEquals("No debe permitir nombre vacio",
                "Nombre Alumnos 1",
                persona1.getNombre());

    }

/* 
     @Test
    public void noPermitirAlumnoConNombreVacio() {

        Persona persona1 = new Alumno("");
        //persona1.setNombre("Nombre Alumno 1");
        
        assertNotNull(persona1.getNombre());

        assertNotEquals("No debe permitir nombre vacio",
                "",
                persona1.getNombre());

    }*/
}
