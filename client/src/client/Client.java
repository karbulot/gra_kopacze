/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author aniej
 */
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class Client
{
    Sender sender;
    Receiver receiver;
    BusinessLogicUnit BLU;
    GameObject game;
    byte dig;
    public static int PORT = 9876;
    
    public Client()
    {
        DatagramSocket clientSocket = null;
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.BLU = new BusinessLogicUnit(this);
        this.sender = new Sender(clientSocket, this, this.BLU);
        this.receiver = new Receiver(clientSocket, this, this.BLU);
        new Thread(this.sender).start();
        new Thread(this.receiver).start();
        new Thread(this.BLU).start();
        dig = 1;
    }
    
    public void setSendData(byte[] data)
    {
        sender.setData(data);
    }
    
    public byte getData()
    {
        return sender.getData();
    }
    
    
    public static void main(String[] args)
    {
        new Client();
    }
}
