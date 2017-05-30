/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.InetAddress;

/**
 *
 * @author aniej
 */
public class ClientRecord {
    private int port;
    private InetAddress iP;
    private byte[] state;
    
    public ClientRecord(int port, InetAddress iP)
    {
        this.port = port;
        this.iP = iP;
        state = new byte[1];
        state[0] = 0;
    }
    
    public byte[] getState()
    {
        return state;
    }
    
    public void setData(byte data)
    {
        state[0] = data;
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
