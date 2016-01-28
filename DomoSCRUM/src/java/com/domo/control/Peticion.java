/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domo.control;

import com.domo.modelo.ArduinoActions;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Peticion
 *
 *
 * @author ChrisV_G
 * @since 20/01/2016
 *
 * Derechos Reservados de Autor. (C)
 *
 * Historia de Modificaciones
 * ------------------------------------------------------------- 
 * Autor             Fecha          Modificacion 
 * ----------------- -------------- ----------------------------
 */
public class Peticion extends HttpServlet {

    private ArduinoActions methods=null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String responseData="";
        PrintWriter out = resp.getWriter();
        try {
            if(methods == null){
                methods= new ArduinoActions();
            }
            switch (req.getParameter("method")) {
                case "login":
                    if("admin".equals(req.getParameter("user")) && "D0m0Scrum".equals(req.getParameter("pass"))){
                        out.println(true); 
                    }else {
                        out.println(false);
                    }
                    break;
                case "temp":
                    responseData=methods.sendCommand(new StringBuffer(3).toString());
                    break;
                case "light":
                    responseData=methods.sendCommand(new StringBuffer(req.getParameter("value")).toString());
                    break;    
                case "status":
                    responseData=methods.sendCommand(new StringBuffer(4).toString());
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("Dato=  " + methods.getDato());
            out.println(responseData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
