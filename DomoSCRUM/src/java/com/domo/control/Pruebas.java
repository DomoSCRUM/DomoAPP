/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.domo.control;

import com.domo.modelo.SerialTest;
import javax.swing.JOptionPane;

/**
 *
 * Pruebas
 *
 *
 * @author ChrisV_G
 * @since 01/12/2015
 *
 * Derechos Reservados de Autor. (C) IP Total Software S.A
 *
 * Historia de Modificaciones
 * ------------------------------------------------------------- 
 * Autor             Fecha          Modificacion 
 * ----------------- -------------- ----------------------------
 */
public class Pruebas {
    
    public static void main(String[] args) throws Exception{
        SerialTest test = new SerialTest();
        test.initialize();
        while(true){
            test.sendMessage(JOptionPane.showInputDialog("Ingrese Valor"));
            System.out.println(test.dato);
            Thread.sleep(1000);
        }
    }
}
