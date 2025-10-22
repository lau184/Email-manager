package com.mycompany.app;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate; //Sirve para usar Predicate que es una función que devuelve true o false
import java.util.stream.Collectors; //Sirve para usar Collectors que permite recolectar elementos de un stream en una colección

//Esta clase representa una bandeja (con Entrada, Enviados, Borradores)
public class Bandeja {

    private String nombre;          //nombre de la bandeja
    private List<Email> correos;    //lista de correos dentro de la bandeja

    public Bandeja(String nombre) {
        this.nombre = nombre;
        this.correos = new ArrayList<>();
    }

    //devuelve el nombre de la bandeja
    public String getNombre() {
        return nombre;
    }

    //agrega un correo a la bandeja
    public void agregar(Email email) {
        if (email != null && !correos.contains(email)) {
            correos.add(email);
        }
    }

    //elimina un correo de la bandeja
    public void eliminar(Email email) {
        correos.remove(email);
    }

    //devuelve una copia de la lista de correos (para no modificar la original)
    public List<Email> getCorreos() {
        return new ArrayList<>(correos);
    }

    //busca correos que cumplan con una condición predicate
    public List<Email> buscar(Predicate<Email> criterio) {
        return correos.stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

    //mueve un correo desde esta bandeja hacia otra
    public void moverA(Email email, Bandeja destino) {
        if (correos.remove(email)) {
            destino.agregar(email);
        }
    }

    //elimina todos los correos
    public void vaciar() {
        correos.clear();
    }
}
