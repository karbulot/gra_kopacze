/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniej
 */
public class Server {
    public List<ClientRecord> clients = new ArrayList<ClientRecord>();
    Sender sender;
    Receiver receiver;
    BusinessLogicUnit BLU;
    
    public Server()
    {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9876);
        } catch (SocketException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        //wątki serwera
        this.receiver = new Receiver(serverSocket, this);
        this.sender = new Sender(serverSocket, this);
        this.BLU = new BusinessLogicUnit(this);
        new Thread(this.receiver).start();
        new Thread(this.sender).start();
        new Thread(this.BLU).start();
    }
    public void addUser(DatagramPacket datagram)
    {
        BLU.addUser(datagram);
    }
    public void translateData(byte data)
    {
        BLU.setData(data);
    }
    public static void main(String[] args)
    {
        new Server();
    }
}
