/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.net.Socket;
/**
 *
 * @author a19216301
 */
public class Connection extends Thread {
    private Socket socket;
    private Out out;
    private In in;
    private String message;
    
    public Connection(Socket socket) {
        in = new In(socket);
        out = new Out(socket);
        this.socket = socket;
    }
    
    public void println(String s) {
        out.println(s);
    }
    
    public void run() {
        String s;
        while ((s = in.readLine()) != null) {
            setMessage(s);
        }
        
        out.close();
        in.close();
        
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.err.println("closing socket");
    }
    
    public synchronized String getMessage() {
        if (message == null) return null;
        
        String temp = message;
        message = null;
        notifyAll();
        return temp;
    }
    
    public synchronized void setMessage(String s) {
        if (message != null) {
            try {
                wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            message = s;
        }
    }
}
