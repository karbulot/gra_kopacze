/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbin;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Archax
 */
public class SbinServer implements Runnable{

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(SBin.PORTinput)) {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    if (socket != null){
                        System.out.println("received msg");
                        ReceiveMessageTask receive = 
                                new ReceiveMessageTask(socket);
                        
                        /* jeden watek */
                        try {
                            receive.call();
                        } catch (Exception e){}
                        
                    } 
                } catch(SocketTimeoutException ex){}
            }
        } catch (IOException ex) {
            Logger.getLogger(SbinServer.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
}
