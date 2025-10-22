package com.mycompany.app;

import java.util.*;

public class GestorEmails {


/** RF-01: crea un borrador y lo guarda en BORRADORES del remitente. */
public Email crearBorrador(Usuario remitente, List<Contacto> para, String asunto, String contenido){
Email borrador = Email.borrador(new Contacto(remitente.getNombre(), remitente.getEmail()), para, asunto, contenido);
remitente.agregarACarpeta(Carpeta.BORRADORES, borrador);
return borrador;
}


/** RF-02: enviar. Coloca en ENVIADOS del remitente y en ENTRADA de cada destinatario (si están en el directorio). */
public Email enviar(Usuario remitente, Email borrador, Map<String, Usuario> directorioPorEmail){
Email enviado = borrador.esBorrador() ? borrador.marcarEnviado() : borrador;
remitente.agregarACarpeta(Carpeta.ENVIADOS, enviado);
for (Contacto c : enviado.getPara()){
Usuario destino = directorioPorEmail.get(c.getEmail());
if (destino != null) destino.agregarACarpeta(Carpeta.ENTRADA, enviado);
}
return enviado;
}


/** Atajo: permitir armar la lista de destinatarios por **nombre de contacto** del remitente. */
public List<Contacto> resolverDestinatariosPorNombres(Usuario remitente, List<String> nombres){
List<Contacto> destinatarios = new ArrayList<>();
for (String n : nombres){
remitente.buscarContactoPorNombre(n).ifPresent(destinatarios::add);
}
return destinatarios;
}
}