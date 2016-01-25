/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domo;

import gnu.io.SerialPort;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ipt_comunicaciones05
 */
public class Peticion extends HttpServlet {

    SerialPort serialPort;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            if (!Values.isConnected()) {
                Values.start();
            }
            PrintWriter out = resp.getWriter();
            Values.main.sendMessage("" + req.getParameter("option"));
            System.out.println("Dato=  " + SerialTest.dato);
            out.println(SerialTest.dato.replace("\n", ""));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
