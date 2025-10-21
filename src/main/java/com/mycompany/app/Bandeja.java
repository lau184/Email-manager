package com.mycompany.app;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Esta clase representa una bandeja (Entrada, Enviados, Borradores)
public class Bandeja {

    private String nombre;          // Nombre de la bandeja
    private List<Email> correos;    // Lista de correos dentro de la bandeja

    public Bandeja(String nombre) {
        this.nombre = nombre;
        this.correos = new ArrayList<>();
    }

    // Devuelve el nombre de la bandeja
    public String getNombre() {
        return nombre;
    }

    // Agrega un correo a la bandeja
    public void agregar(Email email) {
        if (email != null && !correos.contains(email)) {
            correos.add(email);
        }
    }

    // Elimina un correo de la bandeja
    public void eliminar(Email email) {
        correos.remove(email);
    }

    // Devuelve una copia de la lista de correos (para no modificar la original)
    public List<Email> getCorreos() {
        return new ArrayList<>(correos);
    }

    // Busca correos que cumplan con una condición (Predicate)
    public List<Email> buscar(Predicate<Email> criterio) {
        return correos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    // Mueve un correo desde esta bandeja hacia otra
    public void moverA(Email email, Bandeja destino) {
        if (correos.remove(email)) {
            destino.agregar(email);
        }
    }

    // Elimina todos los correos
    public void vaciar() {
        correos.clear();
    }
}
