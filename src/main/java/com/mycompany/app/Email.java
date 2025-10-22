package com.mycompany.app;

import java.util.Objects;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

/** RF-01/02: Email básico. */
public class Email {
private final String asunto;
private final String contenido;
private final Contacto remitente; // único
private final List<Contacto> para; // uno o varios
private final LocalDateTime creado;
private final LocalDateTime enviado; // null si borrador


private Email(String asunto, String contenido, Contacto remitente, List<Contacto> para,
LocalDateTime creado, LocalDateTime enviado){
this.asunto = asunto == null ? "" : asunto;
this.contenido = contenido == null ? "" : contenido;
this.remitente = Objects.requireNonNull(remitente);
this.para = List.copyOf(Objects.requireNonNull(para));
this.creado = Objects.requireNonNull(creado);
this.enviado = enviado; // puede ser null
}


public static Email borrador(Contacto remitente, List<Contacto> para, String asunto, String contenido){
if (para == null || para.isEmpty()) throw new IllegalArgumentException("Debe haber al menos un destinatario");
return new Email(asunto, contenido, remitente, para, LocalDateTime.now(), null);
}
public Email marcarEnviado(){
return new Email(asunto, contenido, remitente, para, creado, LocalDateTime.now());
}


public String getAsunto(){ return asunto; }
public String getContenido(){ return contenido; }
public Contacto getRemitente(){ return remitente; }
public List<Contacto> getPara(){ return para; }
public boolean esBorrador(){ return enviado == null; }
public Optional<LocalDateTime> getEnviado(){ return Optional.ofNullable(enviado); }
}