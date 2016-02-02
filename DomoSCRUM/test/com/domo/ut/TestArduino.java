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
    
    
    /**
     * Se instala lo necesario para que el aplicativo funcione
     *
     */
    @Before
    public void setUp() {
        actions=new ArduinoActions();
      
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Metodo que testea la conexión con el arduino
     */
     @Test
     public void testConnection() {
         assertTrue(actions.isConnected());
     }
     
     /**
     * Metodo que testea la conexión con el arduino
     */
     @Test
     public void testTemp() {
         int seleccion=3;//valor que envía la petición para saber la temperatura
         assertNotNull(actions.sendCommand(new StringBuffer(seleccion).toString()));
     }
}
