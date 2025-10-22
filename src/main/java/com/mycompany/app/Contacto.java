package com.mycompany.app;

import java.util.Objects; //para usar métodos útiles, como 'requireNonNull' (ver más abajo)

//RF-03: Contacto simple (nombre + email)
//Representa un contacto con dos datos: nombre y correo

public class Contacto {

    //atributos (datos que guarda cada contacto)
    private String nombre;  //Nombre del contacto
    private String email;   //Dirección de correo electrónico del contacto

    //Constructor: se usa para crear un nuevo contacto con nombre y email
    public Contacto(String nombre, String email) {
        //Objects.requireNonNull evita que los valores sean nulos (lanza un error si lo son)
        this.nombre = Objects.requireNonNull(nombre);
        this.email = Objects.requireNonNull(email);
    }

    //metodo get (leer) los valores de los atributos
    public String getNombre() { 
        return nombre; 
    }

    public String getEmail() { 
        return email; 
    }

    //metodo set (modificar) los valores de los atributos
    public void setNombre(String nuevo) { 
        this.nombre = Objects.requireNonNull(nuevo); 
    }

    public void setEmail(String nuevo) { 
        this.email = Objects.requireNonNull(nuevo); 
    }

    //sobrescribe el método 'toString' para mostrar el contacto en formato legible
    @Override 
    public String toString() { 
        //ejemplo: Juan Pérez <juan@gmail.com>
        return nombre + " <" + email + ">"; 
    }
}
