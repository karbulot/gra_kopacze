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
    private byte[] data;
    private byte[] oldData;
    private byte[] receive;
    
    public ClientRecord(int port, InetAddress iP)
    {
        this.port = port;
        this.iP = iP;
        data = new byte[4];
        oldData = new byte[4];
        receive = new byte[1];
    }
    
    public void setReceive(byte[] receive)
    {
        this.receive[0] = receive[0];
    }
    
    public byte[] getReceive()
    {
        return receive;
    }
    
    public byte[] getData()
    {
        return data;
    }
    
    public byte[] getOldData()
    {
        return oldData;
    }
    
    public void setOldData(byte[] data)
    {
        oldData[0] = data[0];
    }
    
    public void setData(byte[] data)
    {
        this.data[0] = data[0];
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
