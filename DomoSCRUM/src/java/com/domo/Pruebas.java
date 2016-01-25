/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.domo;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Pruebas {
    public static void main(String[] args) throws Exception{
        SerialTest test = new SerialTest();
        test.initialize();
        while(true){
            test.sendMessage(JOptionPane.showInputDialog("Ingrese Valor"));
            Thread.sleep(1000);
        }
    }
}
