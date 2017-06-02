/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbin;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;

/**
 *
 * @author Archax
 */
public class SendMessageTask extends Task<Void> {
    byte[] instruction; //rozkaz do przesłania
    KbinServer server;
    
    public SendMessageTask(byte[] instruction, KbinServer server) { 
        this.instruction = new byte[instruction.length];
        System.arraycopy(instruction, 0, this.instruction, 0, instruction.length);
        this.server = server;
    }
 
    @Override 
    protected Void call() throws Exception { 
            System.out.println("SendMessageTask start");
            try (Socket socket = new Socket("localhost", KBin.PORToutput);
                OutputStream output = socket.getOutputStream();
                BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(instruction)) {}) {
            byte[] buffer = new byte[4]; //bufor 4B
            int readSize;
            while ((readSize = input.read(buffer)) != -1) {
                output.write(buffer, 0, readSize);
            }
            System.out.println("SendMessageTask done");
        } catch (IOException e){
            Logger.getLogger(SendMessageTask.class.getName()).log(Level.WARNING, e.getMessage(), e);   
        }
        return null;
    }
}
