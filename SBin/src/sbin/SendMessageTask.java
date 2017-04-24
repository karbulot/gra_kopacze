/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbin;

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
 
    public SendMessageTask(byte[] instruction) { 
        this.instruction = new byte[instruction.length];
        System.arraycopy(instruction, 0, this.instruction, 0, instruction.length);
    }
 
    @Override 
    protected Void call() throws Exception { 
            try (Socket socket = new Socket("localhost", SBin.PORToutput);
                OutputStream output = socket.getOutputStream();
                BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(instruction)) {}) {
            byte[] buffer = new byte[4096]; //bufor 4KB
            int readSize;
            while ((readSize = input.read(buffer)) != -1) {
                output.write(buffer, 0, readSize);
            }
        } catch (IOException e){
            Logger.getLogger(SendMessageTask.class.getName()).log(Level.WARNING, e.getMessage(), e);   
        }
        return null;
    }
}
