package com.mycompany.app;
import java.util.ArrayList;
import java.util.List;

// Esta clase representa un correo electrónico dentro del sistema.
public class Email {

    private String asunto;          // Asunto del correo
    private String contenido;       // Cuerpo o texto del correo
    private Contacto remitente;     // Persona que envía el correo
    private List<Contacto> para;    // Lista de destinatarios
    private boolean leido;          // Indica si el correo fue leído o no
    private boolean favorito;       // Indica si el correo fue marcado como favorito

    // Constructor sin parámetros: crea una lista vacía de destinatarios
    public Email() {
        this.para = new ArrayList<>();
        this.leido = false;
        this.favorito = false;
    }

    // Constructor que recibe los datos principales del correo
    public Email(String asunto, String contenido, Contacto remitente) {
        this(); // Llama al constructor anterior para inicializar la lista
        this.asunto = asunto;
        this.contenido = contenido;
        this.remitente = remitente;
    }

    // ---------------- MÉTODOS GETTER Y SETTER ----------------

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Contacto getRemitente() {
        return remitente;
    }

    public void setRemitente(Contacto remitente) {
        this.remitente = remitente;
    }

    public List<Contacto> getPara() {
        return para;
    }

    // ---------------- MÉTODOS DE ACCIÓN ----------------

    // Agrega un destinatario al correo
    public void agregarPara(Contacto contacto) {
        if (contacto != null && !para.contains(contacto)) {
            para.add(contacto);
        }
    }

    // Marca el correo como leído
    public void marcarLeido() {
        this.leido = true;
    }

    // Marca el correo como no leído
    public void marcarNoLeido() {
        this.leido = false;
    }

    // Marca el correo como favorito
    public void marcarFavorito() {
        this.favorito = true;
    }

    // Quita el estado de favorito
    public void desmarcarFavorito() {
        this.favorito = false;
    }

    // Devuelve si el correo fue leído
    public boolean isLeido() {
        return leido;
    }

    // Devuelve si el correo fue marcado como favorito
    public boolean isFavorito() {
        return favorito;
    }

    
}


