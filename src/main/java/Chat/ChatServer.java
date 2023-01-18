/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.Vector;

/**
 *
 * @author a19216301
 */
public class ChatServer {
    public static void main(String[] args) throws Exception {
        Vector<Connection> connections = new Vector<Connection>();
        ServerSocket serverSocket = new ServerSocket(4444);
        ConnectionListener connectionListener = new ConnectionListener(connections);
        
        connectionListener.start();
        
        System.err.println("ChatServer corriendo");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.err.println("Socket creado con un cliente");
            
            // Listen to client in a separete thread
            Connection connection = new Connection(clientSocket);
            connections.add(connection);
            connection.start();
        }
    }
}
