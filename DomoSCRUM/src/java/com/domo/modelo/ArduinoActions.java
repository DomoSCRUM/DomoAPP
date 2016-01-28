package com.domo.modelo;

/**
 *
 * AlarmService
 *
 *
 * @author ChrisV_G
 * @since 27/01/2016
 *
 * Derechos Reservados de Autor. (C) IP Total Software S.A
 *
 * Historia de Modificaciones
 * -------------------------------------------------- 
 * Autor             Fecha          Modificacion 
 * ----------------- -------------- ------------------
 */
public class ArduinoActions {
    public SerialTest main;
    public boolean status;

    /**
     * Initialize serial port instance
     *
     */
    public ArduinoActions() {
        this.main= new SerialTest();
        this.main.initialize();
    }
    
    
    /**
     * Check the connection state
     * 
     * @return return connection state as a boolean 
     * true=connected 
     * false= disconnected
     */
    public boolean isConnected() {
        return main.connected;
    }
     
     /**
     * Send command to serial port
     * 
     * @param command instruction to be sended
     * @return return serial port response 
     */
    public String sendCommand(String command) {
        try{
        this.main.sendMessage(command);
        return this.main.dato;
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        
    }
     /**
     * return serial port response
     * 
     * @return serial port response
     */
     public String getDato(){
         return this.main.dato;
     };
     
}
