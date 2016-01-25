/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domo;

/**
 *
 * @author christian.valencia
 */
public class Values {

    public static SerialTest main= new SerialTest();
    public static boolean status;

    public static void start() {
        main.initialize();
    }

    public static boolean isConnected() {
        return main.conected;
    }

}
