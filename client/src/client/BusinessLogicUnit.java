/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aniej
 */
public class BusinessLogicUnit implements Runnable{
    
    Client client;
    Sender sender;
    byte[] data;
    byte[] oldData;
    
    public BusinessLogicUnit(Client client, Sender sender)
    {
        this.client = client;
        this.sender = sender;
        data = new byte[4];
        oldData = new byte[4];
    }
    
     public byte[] fill(byte[] a2)
    {
        byte[] a1 = new byte[a2.length];
        for(int i = 0; i < a1.length; i++)
        {
            a1[i] = a2[i];
        }
        return a1;
    }
     
    public void setData(byte[] data)
    {
        this.data[0] = data[0];
        this.data[1] = data[1];
        this.data[2] = data[2];
        this.data[3] = data[3];
    }
    
    @Override
    public void run() {
        System.out.println("oczekiwanie na innych graczy.");
        sender.setData((byte)0);
        while(data[0] == 0);
        System.out.println("xd");
        int i = 3;
        while (i > 0)
        {
            while(i < data[0]);
            System.out.println("Gra rozpocznie się za "+i);
            i--;
        }
        System.out.println("elo.");
    }
    
}
