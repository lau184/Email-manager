package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mycompany.app.Interfaces.INombrable;

import java.util.ArrayList;

public class PooArrayListTest {

     @Test
    public void simpleArrayList() {

      ArrayList<INombrable> alumnos = new ArrayList<INombrable>();

      alumnos.add(new Alumno("Nombre 1")); //indice 0
      alumnos.add(new Alumno("Nombre 2"));
      alumnos.add(new Alumno("Nombre 3"));

      assertEquals(3, alumnos.size());
     
      var alumno1 = alumnos.get(1);
      assertNotNull(alumno1);
      assertEquals("Nombre 2", alumno1.getNombre());
    }


     @Test
    public void removePosition1() {

      ArrayList<INombrable> alumnos = new ArrayList<INombrable>();

      alumnos.add(new Alumno("Nombre 1")); //indice 0
      alumnos.add(new Alumno("Nombre 2"));
      alumnos.add(new Alumno("Nombre 3"));

      assertEquals(3, alumnos.size());
     
      var alumno1 = alumnos.get(1);
      assertNotNull(alumno1);
      assertEquals("Nombre 2", alumno1.getNombre());

      alumnos.remove(1);
      assertEquals(2, alumnos.size());

    }


      @Test
    public void removeWithObject() {

      ArrayList<INombrable> alumnos = new ArrayList<INombrable>();

      Alumno alumno2 = new Alumno("Nombre 2");
      alumnos.add(new Alumno("Nombre 1")); //indice 0
      alumnos.add(alumno2);
      alumnos.add(new Alumno("Nombre 3"));

      assertEquals(3, alumnos.size());
     
      var alumno1 = alumnos.get(1);
      assertNotNull(alumno1);
      assertEquals("Nombre 2", alumno1.getNombre());

      alumnos.remove(alumno2);
      assertEquals(2, alumnos.size());
      
    }


      @Test
    public void removeAnotherObject() {

      ArrayList<INombrable> alumnos = new ArrayList<INombrable>();

      Alumno alumno2 = new Alumno("Nombre 2");
      
      Alumno alumno2Dummy = new Alumno("Nombre 2");

      alumnos.add(new Alumno("Nombre 1")); //indice 0
      alumnos.add(alumno2);
      alumnos.add(new Alumno("Nombre 3"));

      assertEquals(3, alumnos.size());
     
      var alumno1 = alumnos.get(1);
      assertNotNull(alumno1);
      assertEquals("Nombre 2", alumno1.getNombre());

      alumnos.remove(alumno2Dummy);
      assertEquals(3, alumnos.size());
      
    }



      @Test
    public void manyArrayList() {

      ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

      Alumno alumno2 = new Alumno("Nombre 2");

      alumnos.add(new Alumno("Nombre 1")); //indice 0
      alumnos.add(alumno2);
      alumnos.add(new Alumno("Nombre 3"));

      assertEquals(3, alumnos.size());
     
      var alumnoPosicion1 = alumnos.get(1);
      assertNotNull(alumnoPosicion1);
      assertEquals("Nombre 2", alumnoPosicion1.getNombre());

      

        ArrayList<Alumno> alumnosParaRendir = new ArrayList<Alumno>();
        alumnosParaRendir.add(alumno2);

        assertEquals(1, alumnosParaRendir.size());

        alumnos.get(1).setNombre("Nombre Nuevo");

        assertEquals("Nombre Nuevo", alumnosParaRendir.get(0).getNombre());
    }

    

}
