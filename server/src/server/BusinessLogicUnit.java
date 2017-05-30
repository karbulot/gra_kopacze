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
    byte oldData;
    byte data;
    
    public BusinessLogicUnit(Server server)
    {
        this.server = server;
        oldData = 127;
        data = 127;
    }
    
    public void setData(byte data)
    {
        this.data = data;
    }
    
    public void addUser(DatagramPacket packet)
    {
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        server.clients.add(new ClientRecord(port, address));
    }
    
    @Override
    public void run() {
        while(true){
            if(oldData != data)
            {
                oldData = data;
                server.clients.get(0).setData(data);
                System.out.println(data);
            }
            System.out.println(oldData + " " + data);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(BusinessLogicUnit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
