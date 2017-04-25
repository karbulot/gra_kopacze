<<<<<<< Updated upstream
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbin;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Archax
 */
public class KBin {

    public static int PORToutput = 1256;
    public static int PORTinput = 1258;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Serwer Start");
        Thread server = new Thread(new KbinServer());
        server.start();
        System.out.println("Sending start");
        byte[] k1 = {1,1,1,1};
        byte[] k2 = {0,0,0,0};
        Scanner input = new Scanner(System.in);
        String text;
        try { 
            while (true){
                text = input.nextLine();
                if ("q".equals(text)){
                    System.out.println("sending k1");
                    SendMessageTask task = new SendMessageTask(k1);
                    try{
                        task.call();
                    }catch (Exception e){
                        System.out.println("error k2");
                    }
                } else if ("w".equals(text)){
                    System.out.println("sending k2");
                    SendMessageTask task = new SendMessageTask(k2);
                    try {
                        task.call();
                    } catch (Exception e){
                        System.out.println("error k2");
                    }  
                }
                Thread.sleep(3000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(KBin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
>>>>>>> Stashed changes
