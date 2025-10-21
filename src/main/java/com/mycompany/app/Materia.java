/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Materia {

   private ArrayList<Alumno> alumnos;

   public Materia() {
      this.alumnos = new ArrayList<Alumno> ();
   }

   
   public ArrayList<Alumno> getAlumnos(){
        return this.alumnos;
   }

   public void agregar(Alumno alumno) {
      
      this.getAlumnos().add(alumno);
   }


}
