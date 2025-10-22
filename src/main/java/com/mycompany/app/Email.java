package com.mycompany.app;

import java.util.Objects;       //para validar que los objetos no sean nulos
import java.util.List;          //para usar listas de contactos
import java.time.LocalDateTime; //para guardar fecha y hora (de creación y envío)
import java.util.Optional;      //para manejar valores que pueden ser nulos (como la fecha de envío)

//RF-01/02:Clase que representa un correo electrónico
public class Email {

    //atributos del correo
    private final String asunto;         
    private final String contenido;     
    private final Contacto remitente;   //quien envia
    private final List<Contacto> para;  //lista de destinatarios
    private final LocalDateTime creado; //fecha y hora de creación
    private final LocalDateTime enviado; //fecha y hora de envío (puede ser null si es borrador)

    // constructor privado (solo se crea desde los métodos estáticos)
    private Email(String asunto, String contenido, Contacto remitente, List<Contacto> para,
                  LocalDateTime creado, LocalDateTime enviado) {
        this.asunto = asunto == null ? "" : asunto;                    //si el asunto es null, lo deja vacío
        this.contenido = contenido == null ? "" : contenido;           //si el contenido es null, lo deja vacío
        this.remitente = Objects.requireNonNull(remitente);            //el remitente no puede ser null
        this.para = List.copyOf(Objects.requireNonNull(para));         //crea una copia inmodificable de la lista de destinatarios
        this.creado = Objects.requireNonNull(creado);                  //la fecha de creación no puede ser null
        this.enviado = enviado;                                        //puede ser null (si todavía no se envió)
    }

    //metodo estático para crear un borrador
    public static Email borrador(Contacto remitente, List<Contacto> para, String asunto, String contenido) {
        if (para == null || para.isEmpty()) 
            throw new IllegalArgumentException("Debe haber al menos un destinatario"); 
        //si la lista de destinatarios está vacía, lanza un error

        return new Email(asunto, contenido, remitente, para, LocalDateTime.now(), null);
        //crea el email con la fecha actual y sin fecha de envío (borrador)
    }

    //metodo que marca el correo como enviado (devuelve una nueva instancia con fecha de envío actual)
    public Email marcarEnviado() {
        return new Email(asunto, contenido, remitente, para, creado, LocalDateTime.now());
    }

    //getters para obtener la información del correo
    public String getAsunto() { return asunto; }
    public String getContenido() { return contenido; }
    public Contacto getRemitente() { return remitente; }
    public List<Contacto> getPara() { return para; }

    //indica si el correo es un borrador (true si todavía no se envió)
    public boolean esBorrador() { return enviado == null; }

    //devuelve la fecha de envío dentro de un Optional (para evitar null directamente)
    public Optional<LocalDateTime> getEnviado() { 
        return Optional.ofNullable(enviado); 
    }
}
