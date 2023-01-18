/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author a19216301
 */
public class Out {
    
    private PrintWriter out;
    
    public Out(Socket socket) {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public void close() {
        out.close();
    }
    
    public void println() {
        out.println();
        out.flush();
    }
    
    public void println(Object x) {
        out.println(x);
        out.flush();
    }
    
    public void print() {
        out.flush();
    }
    
    public void print(Object x) {
        out.print(x);
        out.flush();
    }
    
}
