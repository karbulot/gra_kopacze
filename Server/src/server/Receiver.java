/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author aniej
 */
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Receiver implements Runnable
{
    DatagramSocket serverSocket;
    byte clientsNumber;
    Server server;
    
    public Receiver(DatagramSocket serverSocket, Server server)
    {
        clientsNumber = 0;
        this.serverSocket = serverSocket;
        this.server = server;
    }
    @Override
    public void run()
    {
        byte[] receiveData = new byte[1024];
        while(true)
        {
            System.out.println("Odbieram paczke");
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
                System.out.println("odebralem paczke");
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                server.newClient(port, IPAddress);
                System.out.println("dodalem klienta");
            } catch (IOException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}