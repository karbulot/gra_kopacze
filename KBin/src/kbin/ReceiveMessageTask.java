/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbin;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;

/**
 *
 * @author Archax
 */
public class ReceiveMessageTask extends Task<Void> {
    Socket socket;
    File file;
    KbinServer server;
 
    public ReceiveMessageTask(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }  
    
    public ReceiveMessageTask(Socket socket, KbinServer server)
    {
        this.socket = socket;
        this.file = null;
        this.server = server;
    }

    @Override
    protected Void call() throws Exception {
        System.out.println("ReceiveMessageTask start");
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        ByteArrayOutputStream output = new ByteArrayOutputStream()) {
        byte[] buffer = new byte[4]; //bufor 4B
        int readSize;
        while ((readSize = input.read(buffer)) != -1) {            
                for (int i = 0; i < readSize; i++){
                    System.out.print(Arrays.toString(buffer));
                }               
                output.write(buffer, 0, readSize);
            } 
        
            /* testy */
            if (testk2(output.toByteArray())){
                System.out.println("ReceiveMessageTask Received k2 {1,0,1,0}");
            } else{
                if (testk1(output.toByteArray())){
                    System.out.println("ReceiveMessageTask Received k1 {1,1,1,0}");
                } else{
                    System.out.println("ReceiveMessageTask erros");
                }
            }
            
        } catch (IOException e){
            Logger.getLogger(ReceiveMessageTask.class.getName()).log(Level.WARNING, e.getMessage(), e);   
        }
            return null;
    }
    
    /* testy odebrania komunikatu */
    private boolean testk2(byte[] msg){
        byte[] temp = {1,0,1,0};
        return Arrays.equals(msg, temp);
    }
    
    private boolean testk1(byte[] msg){
        byte[] temp = {1,1,1,0};
        return Arrays.equals(msg, temp);
    }
}
