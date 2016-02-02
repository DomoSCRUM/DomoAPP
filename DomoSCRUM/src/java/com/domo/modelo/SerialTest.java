package com.domo.modelo;

import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;
/**
 *
 * SerialTest
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
public class SerialTest implements SerialPortEventListener {

    public static int state = 0;
    boolean connected = false;
    public String dato = "";
    SerialPort serialPort;
    /**
     * The port we're normally going to use.
     */
    private static final String portName = "COM4";
    /**
     * Buffered input stream from the port
     */
    private static InputStream input;
    /**
     * The output stream to the port
     */
    private static OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 115200;

    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
        // iterate through, looking for the port
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
              break;
            }
        }

        if (portId == null) {
            connected = false;
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            connected = true;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }
    /**
     * Check port state 
     * 
     * @return boolean to check if port is use
     */
    public synchronized boolean connected() {
        if (connected) { // puedo sustituirlo por serialPort !=null
            return true;
        } else {
            return false;
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent port event
     * 
     */
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                int available = input.available();
                byte chunk[] = new byte[available];
                input.read(chunk, 0, available);
                dato = (new String(chunk));
				// Displayed results are codepage dependent

            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

     /**
     * Return message response 
     *
     * @param str string to write on output
     */
    public synchronized void sendMessage(String str) {

        byte[] bytes;
        bytes = str.getBytes();
        try {
            output.write(bytes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
