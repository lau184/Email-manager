package com.mycompany.app;

public class Contacto {   // Esta clase representa un contacto con un nombre y un correo electrónico.
    private String nombre;  //atributo que guarda el nombre del contacto
    private String email;   //atributo que guarda el correo electrónico del contacto
                      //parametros del constructor
    public Contacto(String nombre, String email) { // Constructor que inicializa el nombre y el correo electrónico del contacto
        this.nombre = nombre; 
        this.email = email;
    }

    public String getNombre() {  //metodo getter que devuelve el nombre del contacto
        return nombre;
    }

    public String getEmail() {  //metodo getter que devuelve el correo electrónico del contacto
        return email;
    }

    public void setNombre(String nombre) { //metodo setter permite cambiarel valor del nombre del contacto
        this.nombre = nombre;
    }

    public void setEmail(String email) { //metodo setter permite cambiar el valor del correo electrónico del contacto
        this.email = email;
    }

}