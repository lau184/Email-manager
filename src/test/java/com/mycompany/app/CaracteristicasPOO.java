package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CaracteristicasPOO {
   
    @Test
    public void comportamientoTest() {

        Profesor profesor1 = new Profesor("Profesor 1");
        profesor1.setNombre("Profe A");
        
        Profesor profesor2 = new Profesor("Profesor 1");
        profesor2.setNombre("Profe A");

        profesor1.setTitulo("Titulo del profesor A");

        Persona persona1 = profesor1;
        
        persona1.setNombre("Persona 1");

        Profesor profe = (Profesor)persona1;
      
        assertEquals("ddd", 
                    "Titulo del profesor A",
                      profe.getTitulo() );

        //boolean sinIguales = (profesor2 == persona1);

        //assertTrue(sinIguales);
    }
}
