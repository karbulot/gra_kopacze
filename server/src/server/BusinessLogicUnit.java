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
    byte data;
    
    public BusinessLogicUnit(Server server)
    {
        this.server = server;
        data = 0;
    }
    
    public void setData(byte data)
    {
        this.data = data;
        //System.out.println(data);
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
            System.out.println("Dodano użytkownika o adresie: "+address);
        }
    }
    
    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BusinessLogicUnit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
