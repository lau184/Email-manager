package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class RF02_EnvioTest {

    @Test
    public void enviarAMultiplesDestinatarios_guardaEnEnviadosYEntrada() {
        //gestor
        GestorEmails gm = new GestorEmails();

        //Remitente y destinatarios
        Usuario jose   = new Usuario("Jose", "jose@demo.com");
        Usuario laura  = new Usuario("Laura", "laura@demo.com");
        Usuario german = new Usuario("German", "german@demo.com");

        //Jose arma el borrador para dos contactos
        var para = List.of(
            new Contacto("Laura",  laura.getEmail()),
            new Contacto("German", german.getEmail())
        );
        
        Email borrador = gm.crearBorrador(jose, para, "Reunión", "Les paso el link");

        //directorio a quién entrega en ENTRADA
        Map<String, Usuario> directorio = Map.of(
            jose.getEmail(),   jose,
            laura.getEmail(),  laura,
            german.getEmail(), german
        );

        //Envio
        Email enviado = gm.enviar(jose, borrador, directorio);

        //verificaciones
        assertFalse(enviado.esBorrador());                 // ya no es borrador
        assertEquals(1, jose.ver(Carpeta.ENVIADOS).size()); // quedó en ENVIADOS de Jose
        assertEquals(1, laura .ver(Carpeta.ENTRADA).size()); // llego a ENTRADA de Laura
        assertEquals(1, german.ver(Carpeta.ENTRADA).size()); // llego a ENTRADA de Germán
        assertEquals(2, enviado.getPara().size());           // dos destinatarios
    }
}
