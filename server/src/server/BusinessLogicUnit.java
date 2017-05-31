/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniej
 */
public class BusinessLogicUnit implements Runnable{
    
    Server server;
    byte start;
    
    public BusinessLogicUnit(Server server)
    {
        this.server = server;
        start = 0;
    }
    
    public synchronized void addUser(InetAddress address)
    {
        byte f = 0;
        for (ClientRecord c : server.clients)
        {
            if (c.getIP().equals(address))
            {
                f = 1;
            }
        }
        if (f == 0)
        {
            server.clients.add(new ClientRecord(server.PORT, address));
            System.out.println("Dodano użytkownika o adresie: " + address);
        }
    }
    
    public void startGame()
    {
        start = 3;
    }
    
    @Override
    public void run() {
        while(start == 0)
            {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BusinessLogicUnit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            byte f = 0;
            while(f == 0)
            {
                f = 1;
                for(ClientRecord c: server.clients)
                {
                    if (c.getReceive()[0] != 0)
                        f = 0;
                }
            }
            System.out.println("Startuje");
            byte[] message = new byte[4];
            message[0] = 0;
            message[1] = 0;
            message[2] = 0;
            message[3] = 0;
            while(start > 0){
                message[0] = start;
                for(ClientRecord c: server.clients)
                {
                    c.setData(message);
                    System.out.println("ustawiono "+message[0]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BusinessLogicUnit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                start--;
            }
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(BusinessLogicUnit.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
