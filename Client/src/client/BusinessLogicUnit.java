/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Arrays;

/**
 *
 * @author aniej
 */
public class BusinessLogicUnit implements Runnable{
    
    byte[] lastCommand = null;
    byte[] presentCommand = null;
    
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
        while (true)
        {
            if(!Arrays.equals(lastCommand, presentCommand))
            {
                
            }
        }
    }
    
}
