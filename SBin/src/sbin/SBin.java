/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbin;

/**
 *
 * @author Archax
 */
public class SBin {
    
    public static int PORToutput = 1258;
    public static int PORTinput = 1256;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Serwer Start");
        Thread server = new Thread(new SbinServer());
        server.start();
    }
    
}
