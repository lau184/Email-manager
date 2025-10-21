package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AlumnoTest {

    public AlumnoTest() {
    }

    @Test
    public void testDemo1() {
        assertTrue(true);
    }


    @Test
    public void debeTenerNombreParadigmas2() {
       
        Alumno a1;
        a1 = new Alumno("Alumnos 1");
        a1.setNombre("Paradigmas 2");
        String nombre = a1.getNombre();

        assertEquals("Error nomnbre incorrecto", 
                    "Paradigmas 2",
                     nombre);

    }

    public java.time.LocalDate getFecha20000101(){

        return  java.time.LocalDate.of(2000, 1, 1);
    };

    public java.time.LocalDate getFecha20000911(){

        return  java.time.LocalDate.of(2000, 9, 11);
    };

    public java.time.LocalDate getFecha20010101(){

        return  java.time.LocalDate.of(2001, 1, 1);
    };

    @Test
    public void debeCalcularLaEdad25() {
       
        Alumno a1;
        a1 = new Alumno("Nombre 1");
        
        a1.setFechaNacimiento(this.getFecha20000101());
       
        assertEquals("Error edad incorrecto", 
                    25,
                     a1.edad());

    }

    
    @Test
    public void debeCalcularLaEdad24_v1() {
       
        Alumno a1;
        a1 = new Alumno("Nombre 1");
        
        a1.setFechaNacimiento(this.getFecha20000911());
       
        assertEquals("Error edad incorrecto", 
                    25,
                     a1.edad());

    }


    @Test
    public void debeCalcularLaEdad24_v2() {
       
        Alumno a1;
        a1 = new Alumno("Nombre 1");
        
        a1.setFechaNacimiento(this.getFecha20010101());
       
        assertEquals("Error edad incorrecto", 
                    24,
                     a1.edad());

    }

}
