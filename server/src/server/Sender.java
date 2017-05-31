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
    
    public Sender(DatagramSocket serverSocket, Server server, BusinessLogicUnit BLU)
    {
        this.server = server;
        this.serverSocket = serverSocket;
        this.BLU = BLU;
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
                    client.getData(), client.getData().length, client.getIP(), server.PORT);
                    serverSocket.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("wyslalem wiadomosc klientowi nr " + x);
                //System.out.println("o treści "+client.getData()[0]);
                x++;
            }
            
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(BusinessLogicUnit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
