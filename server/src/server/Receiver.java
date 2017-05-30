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
    byte oldData;
    
    public Receiver(DatagramSocket serverSocket, Server server, BusinessLogicUnit BLU)
    {
        clientsNumber = 0;
        oldData = 0;
        this.serverSocket = serverSocket;
        this.server = server;
        this.BLU = BLU;
    }
    
    @Override
    public void run()
    {
        byte[] receiveData = new byte[4];
        while(server.clients.size() < 3)
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
        while(true)
        {
            DatagramPacket receivePacket = 
                    new DatagramPacket(receiveData, receiveData.length);
            try {
                serverSocket.receive(receivePacket);
            } catch (IOException ex) {
                Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (receiveData[0] != oldData)
            {
                BLU.setData(receiveData[0]);
                oldData = receiveData[0];
            }
        }
    }
    
}