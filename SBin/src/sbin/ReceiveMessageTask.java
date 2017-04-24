/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbin;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
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
 
    public ReceiveMessageTask(Socket socket, File file) {
        this.socket = socket;
        this.file = file;
    }
 
    @Override 
    protected Void call() throws Exception {
        System.out.println("ReceiveMessageTask start");
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096]; //bufor 4KB
            int readSize;
            while ((readSize = input.read(buffer)) != -1) {

                    for (int i = 0; i < readSize; i++){
                        System.out.print(Arrays.toString(buffer));
                    }
                    output.write(buffer, 0, readSize);
                }
            System.out.println("start translate msg");
            TranslateMessageTask translate = 
                    new TranslateMessageTask(output.toByteArray(), new File("D:\\received\\log.txt"));
            try {
                translate.Translate();
            } catch (FileNotFoundException e){
                System.out.println("file not found");
            }
            
            System.out.println("ReceiveMessageTask done");


            } catch (IOException e){
                Logger.getLogger(ReceiveMessageTask.class.getName()).log(Level.WARNING, e.getMessage(), e);   
            }

            return null;
    }

}
