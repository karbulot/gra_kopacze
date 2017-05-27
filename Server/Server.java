/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniej
 */
public class Server {
    public void newClient(int port, InetAddress iP)
    {
        
    }
    public Server()
    {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9876);
        } catch (SocketException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread receiver = new Thread(new Receiver(serverSocket, this));
        Thread sender = new Thread(new Sender(serverSocket, this));
        //Thread BLU
        receiver.start();
        sender.start();
        //BLU.start();
        
    }
    public static void main(String[] args)
    {
        Server server = new Server();
    }
}
