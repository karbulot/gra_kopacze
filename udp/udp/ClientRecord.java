/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.net.InetAddress;

/**
 *
 * @author aniej
 */
public class ClientRecord {
    private int port;
    private InetAddress iP;
    
    public ClientRecord(int port, InetAddress iP)
    {
        this.port = port;
        this.iP = iP;
    }
    
    public int getPort()
    {
        return port;
    }
    
    public InetAddress getIP()
    {
        return iP;
    }
}
