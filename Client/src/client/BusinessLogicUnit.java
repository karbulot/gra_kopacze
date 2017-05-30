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
    byte[] lastCommand = null;
    byte[] presentCommand = null;
    
    public BusinessLogicUnit(Client client)
    {
        this.client = client;
    }
    
    public void translate(byte[] command)
    {
        if (!Arrays.equals(lastCommand, command))
        {
            
        }
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
    
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        byte i;
        while (true)
        {
            i = scanner.nextByte();
            System.out.println(i);
            byte x = client.getData();
            byte y = (byte)(1 <<( i - 1));
            System.out.println(y);
            byte[] data = new byte[1];
            data[0] = (byte)(x - y);
            client.setSendData(data);
            System.out.println(x);
            System.out.println(data[0]);
        }
    }
    
}
