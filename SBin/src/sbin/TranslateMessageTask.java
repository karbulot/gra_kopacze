/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Archax
 * 
 * który ostatecznie, na razie nawet nie jest taskiem
 */
public class TranslateMessageTask {
    
    private final byte[] instruction;
    private final File logs;
    
    public TranslateMessageTask(byte[] instruction, File file){
        this.logs = file;
        this.instruction = new byte[instruction.length];
        System.arraycopy(instruction, 0, this.instruction, 0, instruction.length);
    }

    
     public void Translate() throws FileNotFoundException {
        System.out.println("TranslateMessageTask start");
        String message = new String();
        message = "ok";
        try (PrintWriter output = new PrintWriter(logs)) {
            output.print(message);
        }
    }
    
    
}
