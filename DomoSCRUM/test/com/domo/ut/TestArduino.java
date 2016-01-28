package com.domo.ut;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.domo.modelo.ArduinoActions;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author christian.valencia
 */
public class TestArduino {
    
    private ArduinoActions actions;
    
    public TestArduino() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        actions=new ArduinoActions();
      
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void testConnection() {
         assertTrue(actions.isConnected());
     }
     
     /*@Test
     public void testTemp() {
         assert(true,actions.isConnected());
     }*/
}
