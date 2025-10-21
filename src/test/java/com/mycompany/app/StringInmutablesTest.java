package com.mycompany.app;

import java.time.LocalDate;
import java.util.function.Predicate;

import org.junit.Test;

public class StringInmutablesTest {
    
    @Test
    public void test1() {
        String demo = "Demo";

        for (int i = 0; i < 1000; i++){
            demo = demo + " inmutable";
        }
       

        org.junit.Assert.assertTrue(demo.length() > 0);
    }


    @Test
    public void test2() {
        String demo = "Demo";

        StringBuilder sb = new StringBuilder(demo);

        for (int i = 0; i < 1000000; i++){
            sb.append(demo);
            sb.append(" inmutable");
        }


        org.junit.Assert.assertTrue(sb.length() > 0);
    }
}