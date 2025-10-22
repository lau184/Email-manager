package com.mycompany.app;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RF01_CreacionTest {

    @Test
    public void crearCorreoConPara_obligatorio() {
        GestorEmails gm = new GestorEmails();
        var contacto = List.of(new Contacto("Laura", "Laura@demo.com"));
        Usuario joseUsuario = new Usuario("Jose", "jose@demo.com");

        Email borrador = gm.crearBorrador(joseUsuario, contacto, "Asunto", "Texto");

        assertTrue(borrador.esBorrador());
        assertEquals(1, joseUsuario.ver(Carpeta.BORRADORES).size());
        assertEquals("Asunto", borrador.getAsunto());
        assertEquals("Texto", borrador.getContenido());
        assertEquals("jose@demo.com", borrador.getRemitente().getEmail());
        assertEquals(1, borrador.getPara().size());
    }
    @Test
    public void crearBorradorParaDosDestinatarios() {
        // Instanciamos el gestor de emails
        GestorEmails gm = new GestorEmails();

        // José quiere enviar a dos personas (Laura y Germán)
        var contactos = List.of(
            new Contacto("Laura", "laura@demo.com"),
            new Contacto("German", "german@demo.com")
        );

        // Creamos el usuario José (remitente)
        Usuario joseUsuario = new Usuario("Jose", "jose@demo.com");

        // José crea el borrador
        Email borrador = gm.crearBorrador(joseUsuario, contactos, "Reunión", "Les paso el link de la reunión");

        // Verificaciones
        assertTrue(borrador.esBorrador()); // sigue siendo un borrador
        assertEquals(1, joseUsuario.ver(Carpeta.BORRADORES).size()); // el borrador se guardó en BORRADORES
        assertEquals("Reunión", borrador.getAsunto());
        assertEquals("Les paso el link de la reunión", borrador.getContenido());
        assertEquals("jose@demo.com", borrador.getRemitente().getEmail());

        // Nueva validación: ahora debe haber dos destinatarios
        assertEquals(2, borrador.getPara().size());

        // (Opcional) podemos verificar que los destinatarios son los correctos
        assertEquals("laura@demo.com", borrador.getPara().get(0).getEmail());
        assertEquals("german@demo.com", borrador.getPara().get(1).getEmail());
    }
}
