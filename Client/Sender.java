/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniej
 */
public class Sender implements Runnable{
    DatagramSocket clientSocket;
    Client client;
    byte[] data;
    InetAddress IPAddress;
    
    Sender(DatagramSocket clientSocket, Client client) {
        this.clientSocket = clientSocket;
        this.client = client;
        data = new byte[4];
        data[0] = 0;
        data[1] = 0;
        data[2] = 0;
        data[3] = 0;
        try {
            this.IPAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setData(byte[] data)
    {
        this.data = data;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
            } catch (IOException ex) {
                Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
