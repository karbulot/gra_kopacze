/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniej
 */
public class Sender implements Runnable{
    DatagramSocket serverSocket;
    Server server;
    
    public Sender(DatagramSocket serverSocket, Server server)
    {
        this.server = server;
        this.serverSocket = serverSocket;
    }
    
    
    @Override
    public void run()
    { 
        while (true)
        {
            int x = 1;
            for (ClientRecord client : server.clients)
            {
                //System.out.println(
                 //   "Przygotowuje sie do wyslania wiadomosci klientowi " + x);
                try { 
                    DatagramPacket sendPacket = new DatagramPacket(
                    client.getState(), client.getState().length, client.getIP(), client.getPort());
                    serverSocket.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                }
               // System.out.println("wyslalem wiadomosc klientowi nr " + x);
                x++;
            }
        }
    }
}
