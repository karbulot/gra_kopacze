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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class Receiver implements Runnable
{
    DatagramSocket serverSocket;
    byte clientsNumber;
    Server server;
    BusinessLogicUnit BLU;
    
    public Receiver(DatagramSocket serverSocket, Server server, BusinessLogicUnit BLU)
    {
        clientsNumber = 0;
        this.serverSocket = serverSocket;
        this.server = server;
        this.BLU = BLU;
    }
    
    @Override
    public void run()
    {
        byte[] receiveData = new byte[1];
        while(server.clients.size() < 1)
        {
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
            } catch (IOException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            BLU.addUser(receivePacket.getAddress());
        }
        BLU.startGame();
        while(true)
        {
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
            } catch (IOException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(ClientRecord c : server.clients)
            {
                if (receivePacket.getAddress().equals(c.getIP()))
                {
                    c.setReceive(receiveData);
                }
            }
        }
    }
    
}