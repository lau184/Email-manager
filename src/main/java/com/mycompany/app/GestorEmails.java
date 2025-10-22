package com.mycompany.app;

import java.util.*;  //importa todas las clases del paquete java.util (como List, Map, ArrayList, etc.)


public class GestorEmails {

    // RF1: crea un borrador y lo guarda en BORRADORES del remitente 
    public Email crearBorrador(Usuario remitente, List<Contacto> para, String asunto, String contenido) {
        //crea un nuevo correo tipo borrador usando los datos del remitente
        Email borrador = Email.borrador(
            new Contacto(remitente.getNombre(), remitente.getEmail()), // crea el contacto del remitente
            para, 
            asunto, 
            contenido
        );

        //guarda el borrador en la carpeta BORRADORES del usuario remitente
        remitente.agregarACarpeta(Carpeta.BORRADORES, borrador);

        //devuelve el borrador creado
        return borrador;
    }

    // RF2: enviar. coloca en ENVIADOS del remitente y en ENTRADA de cada destinatario
    public Email enviar(Usuario remitente, Email borrador, Map<String, Usuario> directorioPorEmail) {
        //si el correo todavía es un borrador, lo marca como enviado (pone la fecha actual)
        //si ya fue enviado antes, lo deja igual
        Email enviado = borrador.esBorrador() ? borrador.marcarEnviado() : borrador;

        //agrega el correo enviado a la carpeta ENVIADOS del remitente
        remitente.agregarACarpeta(Carpeta.ENVIADOS, enviado);

        //recorre todos los destinatarios del correo
        for (Contacto c : enviado.getPara()) {
            //busca si el destinatario existe en las lista de usuarios por email
            Usuario destino = directorioPorEmail.get(c.getEmail());

            //si el usuario destino existe, agrega el correo a su bandeja de ENTRADA
            if (destino != null) destino.agregarACarpeta(Carpeta.ENTRADA, enviado);
        }

        //devuelve el correo ya enviado
        return enviado;
    }

    //permite armar la lista de destinatarios por nombre de contacto del remitente 
    public List<Contacto> resolverDestinatariosPorNombres(Usuario remitente, List<String> nombres) {
        //crea una lista vacía para guardar los contactos encontrados
        List<Contacto> destinatarios = new ArrayList<>();

        //recorre cada nombre dado
        for (String n : nombres) {
            //busca el contacto en la lista del remitente y, si existe, lo agrega a la lista
            remitente.buscarContactoPorNombre(n).ifPresent(destinatarios::add);
        }

        //devuelve la lista final de contactos destinatarios
        return destinatarios;
    }
}
