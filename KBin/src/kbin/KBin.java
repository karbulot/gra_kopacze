/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbin;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Archax
 */
public class KBin {

    public static int PORT = 1256;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte[] b = {1,1,1};
        try { 
            while (true){
                System.out.println("send");
                SendMessageTask task = new SendMessageTask(b);
                try{
                    task.call();
                }catch (Exception e){
                }
                
                Thread.sleep(3000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(KBin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
