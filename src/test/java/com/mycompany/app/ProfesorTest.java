package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ProfesorTest {

    public ProfesorTest() {
    }

    

    @Test
    public void debeTenerNombre() {
       
        Profesor p1;
        p1 = new Profesor("Profesor 1");
        p1.setNombre("Profesor A");
        String nombre = p1.getNombre();

        assertEquals("Error nomnbre incorrecto", 
                    "Profesor A",
                     nombre);

    }

}
