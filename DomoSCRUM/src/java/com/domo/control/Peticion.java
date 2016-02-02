/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domo.control;

import com.domo.modelo.ArduinoActions;
import com.domo.modelo.SerialTest;
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

    //private ArduinoActions methods=null;
    SerialTest methods = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String responseData="";
        PrintWriter out = resp.getWriter();
        try {
            if(methods == null){
                methods= new SerialTest();
                methods.initialize();
            }
            methods.dato="";
            switch (req.getParameter("method")) {
                case "login":
                    if("admin".equals(req.getParameter("user")) && "D0m0Scrum".equals(req.getParameter("pass"))){
                        out.println(true); 
                    }else {
                        out.println(false);
                    }
                    break;
                case "temp":
                    methods.dato="";
                    while(responseData.equals("")){
                        Thread.sleep(1000);
                        methods.sendMessage("3");
                        responseData=(methods.dato);
                        Thread.sleep(1000);
                        
                    }
                    break;
                case "light":
                    methods.sendMessage(new StringBuffer(req.getParameter("value")).toString());
                    if("1".equals(req.getParameter("value"))){
                        responseData="1";
                    }else{
                        responseData="0";
                    }
                    break;    
                case "states":
                    responseData="";
                    while(!responseData.contains(",")){
                        methods.dato="";
                        methods.sendMessage("3");
                        methods.sendMessage("4");
                        Thread.sleep(1000);
                        methods.sendMessage("4");
                        responseData=methods.dato;
                    }
                    break;
                default:
                    throw new Exception("ERROR Solicitando "+req.getParameter("method"));
            }
            System.out.println("Dato=  " + methods.dato);
            out.println(responseData);

        } catch (Exception e) {
            out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
