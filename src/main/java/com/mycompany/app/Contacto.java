package com.mycompany.app;

import java.util.Objects;


/** RF-03: Contacto simple (nombre + email). */
public class Contacto {
private String nombre;
private String email; // simplificado a String


public Contacto(String nombre, String email){
this.nombre = Objects.requireNonNull(nombre);
this.email = Objects.requireNonNull(email);
}
public String getNombre(){ return nombre; }
public String getEmail(){ return email; }


public void setNombre(String nuevo){ this.nombre = Objects.requireNonNull(nuevo); }
public void setEmail(String nuevo){ this.email = Objects.requireNonNull(nuevo); }


@Override public String toString(){ return nombre + " <" + email + ">"; }
}