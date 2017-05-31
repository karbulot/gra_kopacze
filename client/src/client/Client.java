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
    public static int PORT = 9876;
    
    public Client()
    {
        DatagramSocket clientSocket = null;
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sender = new Sender(clientSocket, this, this.BLU);
        this.BLU = new BusinessLogicUnit(this, this.sender);
        this.receiver = new Receiver(clientSocket, this, this.BLU);
        new Thread(this.sender).start();
        new Thread(this.BLU).start();
        new Thread(this.receiver).start();
    }
    
    public static void main(String[] args)
    {
        new Client();
    }
}
