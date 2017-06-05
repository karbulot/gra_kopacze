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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniej
 */
public class Sender implements Runnable{
    DatagramSocket serverSocket;
    Server server;
    BusinessLogicUnit BLU;
    byte start;
    
    public Sender(DatagramSocket serverSocket, Server server, BusinessLogicUnit BLU)
    {
        this.server = server;
        this.serverSocket = serverSocket;
        this.BLU = BLU;
        start = 0;
    }
    
    public void startGame()
    {
        start = 1;
    }
    
    @Override
    public void run()
    { 
        while(start == 0)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while (true)
        {
            int x = 1;
            for (ClientRecord client : server.clients)
            {
                try { 
                    DatagramPacket sendPacket = new DatagramPacket(
                    client.getData(), client.getData().length, client.getIP(), server.PORT+x);
                    serverSocket.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("wyslalem wiadomosc klientowi nr " + (server.PORT+x));
                //System.out.println("o treści "+client.getData()[0]);
                
                x++;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
