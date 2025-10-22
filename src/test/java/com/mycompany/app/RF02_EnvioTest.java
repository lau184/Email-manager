package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class RF02_EnvioTest {

    @Test
    public void enviarAMultiplesDestinatarios_guardaEnEnviadosYEntrada() {
        // Gestor
        GestorEmails gm = new GestorEmails();

        // Remitente y destinatarios
        Usuario jose   = new Usuario("Jose", "jose@demo.com");
        Usuario laura  = new Usuario("Laura", "laura@demo.com");
        Usuario german = new Usuario("German", "german@demo.com");

        // José arma el borrador para dos contactos
        var para = List.of(
            new Contacto("Laura",  laura.getEmail()),
            new Contacto("German", german.getEmail())
        );
        
        Email borrador = gm.crearBorrador(jose, para, "Reunión", "Les paso el link");

        // Directorio: a quién “entregar” en ENTRADA
        Map<String, Usuario> directorio = Map.of(
            jose.getEmail(),   jose,
            laura.getEmail(),  laura,
            german.getEmail(), german
        );

        // Envío
        Email enviado = gm.enviar(jose, borrador, directorio);

        // Asserts
        assertFalse(enviado.esBorrador());                 // ya no es borrador
        assertEquals(1, jose.ver(Carpeta.ENVIADOS).size()); // quedó en ENVIADOS de José
        assertEquals(1, laura .ver(Carpeta.ENTRADA).size()); // llegó a ENTRADA de Laura
        assertEquals(1, german.ver(Carpeta.ENTRADA).size()); // llegó a ENTRADA de Germán
        assertEquals(2, enviado.getPara().size());           // dos destinatarios
    }
}
