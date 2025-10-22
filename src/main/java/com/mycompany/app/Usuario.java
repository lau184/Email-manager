package com.mycompany.app;

import java.util.Objects;        //valida que los objetos no sean nulos
import java.util.List;           //usa listas
import java.util.ArrayList;      //implementación de lista
import java.util.Map;            //usar mapas 
import java.util.EnumMap;        //mapa especial donde las claves son enums (osea Carpeta)
import java.util.Optional;       //maneja valores que pueden ser nulos
import java.util.stream.Collectors; //transforma resultados de streams en listas

public class Usuario {

    private final String nombre; 
    private final String email;  

    //lista de contactos del usuario (RF3)
    private final List<Contacto> contactos = new ArrayList<>();

    //bandejas del usuario (entrada, enviados, borradores, eliminados)
    //usa un EnumMap porque las claves son del tipo Carpeta (enum)
    private final Map<Carpeta, List<Email>> bandejas = new EnumMap<>(Carpeta.class);

    //constructor
    public Usuario(String nombre, String email) {
        this.nombre = Objects.requireNonNull(nombre); //nombre no puede ser null
        this.email = Objects.requireNonNull(email);   //email tampoco puede ser null

        //crea una lista vacía para cada tipo de carpeta (entrada, enviados, etc.)
        for (Carpeta c : Carpeta.values()) bandejas.put(c, new ArrayList<>());

        //se agrega a sí mismo como contacto (por conveniencia)
        contactos.add(new Contacto(nombre, email));
    }

    //getters para obtener nombre y email
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

//RF3 CONTACTOS
    //agrega un contacto nuevo a la lista
    public void agregarContacto(Contacto c) { contactos.add(c); }

    //elimina un contacto buscando por nombre 
    public boolean eliminarContactoPorNombre(String nombre) {
        return contactos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    }

    //busca un contacto por nombre y devuelve un Optional (por si no lo encuentra)
    public Optional<Contacto> buscarContactoPorNombre(String nombre) {
        //uso de stream y filter para buscar el primer contacto que coincida con el nombre
        return contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    //devuelve cuántos contactos tiene el usuario
    public int cantidadDeContactos() {
        return contactos.size();
    }

    //devuelve una copia de la lista de contactos (para no modificar la original)
    public List<Contacto> verContactos() { 
        return List.copyOf(contactos); 
    }

    //RF6 BANDEJAS

    //agrega un correo a una carpeta específica (entrada, enviados, etc.)
    public void agregarACarpeta(Carpeta carpeta, Email email) { 
        bandejas.get(carpeta).add(email); 
    }

    //devuelve una copia de los correos de una carpeta
    public List<Email> ver(Carpeta carpeta) { 
        return List.copyOf(bandejas.get(carpeta)); 
    }

    //mueve un correo de una carpeta a otra (por ejemplo, de entrada a eliminados)
    public boolean mover(Email email, Carpeta desde, Carpeta hacia) {
        List<Email> src = bandejas.get(desde);
        if (src.remove(email)) { 
            bandejas.get(hacia).add(email); 
            return true; //si se movió correctamente
        }
        return false; //si no estaba en la carpeta original
    }

    // elimina un correo (lo mueve a la carpeta de eliminados)
    public boolean eliminar(Email email, Carpeta desde) { 
        return mover(email, desde, Carpeta.ELIMINADOS); 
    }

    //restaura un correo desde eliminados hacia entrada
    public boolean restaurar(Email email) { 
        return mover(email, Carpeta.ELIMINADOS, Carpeta.ENTRADA); 
    }

    //RF4: BUSQUEDA EN  ENTRADA 
    //busca correos en la bandeja de entrada que contengan cierto texto
    public List<Email> buscarEnEntrada(String texto) {
        //convierte el texto a minúsculas para comparar sin importar mayúsculas
        String q = (texto == null ? "" : texto).toLowerCase();

        //uso de filter   se queda con los correos que contienen el texto en algún campo
        //uso de map   transforma los contactos en sus nombres/emails para comparar
        return bandejas.get(Carpeta.ENTRADA).stream().filter(e ->
            e.getAsunto().toLowerCase().contains(q) ||
            e.getContenido().toLowerCase().contains(q) ||
            e.getRemitente().getEmail().toLowerCase().contains(q) ||
            e.getPara().stream().map(Contacto::getEmail).anyMatch(mail -> mail.toLowerCase().contains(q)) ||
            e.getPara().stream().map(Contacto::getNombre).anyMatch(nom -> nom.toLowerCase().contains(q))
        ).collect(Collectors.toList()); //convierte el resultado filtrado en una lista
    }
}
