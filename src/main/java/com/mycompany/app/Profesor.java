/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.time.LocalDate;
import java.time.Period;

public class Profesor 
            extends Persona
            implements IDarClase {

                
   public Profesor(String nombre) {
         super(nombre);
   }

    private String titulo;

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String valor){
         this.titulo = valor;
    }

    @Override
    public String asistencia() {

        return String.format("Ir al campus a marcar (%s)", super.asistencia());
    }

    public String darClase() {
        return "El profesor esta dando clase";
    }
    

}
