package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContactoTest {

    @Test
    public void crearContactoYVerificarDatos() {
        Contacto contacto = new Contacto("Laura", "laura@ucp.edu.ar");

        assertEquals("Laura", contacto.getNombre());
        assertEquals("laura@ucp.edu.ar", contacto.getEmail());
    }
}
