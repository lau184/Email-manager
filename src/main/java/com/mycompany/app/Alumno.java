/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;


public class Alumno 
      extends Persona {


   public Alumno(String nombre) {
         super(nombre);
   }

   @Override
   public String asistencia() {
       return "Decir presente al profesor";
   }
}
