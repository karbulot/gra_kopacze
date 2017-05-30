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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;

/**
 *
 * @author aniej
 */
public class Receiver implements Runnable{
    DatagramSocket clientSocket;
    Client client;

    Receiver(DatagramSocket clientSocket, Client client) {
        this.clientSocket = clientSocket;
        this.client = client;
    }

    @Override
    public void run() {
        byte[] receiveData = new byte[4];
        DatagramPacket receivePacket = 
                new DatagramPacket(receiveData, receiveData.length);
        while(true)
        {
            try {
                clientSocket.receive(receivePacket);
            } catch (IOException ex) {
                Logger.getLogger(
                        Receiver.class.getName()).log(Level.SEVERE, null, ex);
            }
            client.businessLogic(receiveData);
        }
    }

}
