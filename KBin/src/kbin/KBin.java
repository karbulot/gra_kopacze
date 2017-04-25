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
        KbinServer kbinServer = new KbinServer();
        Thread server = new Thread(kbinServer);
        server.start();
        
        System.out.println("Sending start");
        byte[] imHere = {1,1,1,1};
        byte[] dontLet = {0,0,0,0};
        Scanner input = new Scanner(System.in);
        String text;
        while (true){
            text = input.nextLine();
            if ("q".equals(text)){
                System.out.println("sending xD");
                SendMessageTask task = new SendMessageTask(imHere, kbinServer);
                try{
                    task.call();
                }catch (Exception e){
                    System.out.println("error xD");  
                }
            } else if ("w".equals(text)){
                System.out.println("sending dd");
                SendMessageTask task = new SendMessageTask(dontLet, kbinServer);
                try{
                    task.call();
                }catch (Exception e){
                    System.out.println("error dd");
                }
            }
            //Thread.sleep(3000);
        }
    }
    
}
