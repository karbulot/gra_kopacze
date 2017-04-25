/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbin;

import java.io.File;
import java.util.Arrays;
import javafx.concurrent.Task;

/**
 *
 * @author Archax
 * 
 * który ostatecznie, na razie nawet nie jest taskiem
 */
public class TranslateMessageTask extends Task<Void> {
    
    private byte[] instruction;
    private final File logs;
    SbinServer server;
    
    public TranslateMessageTask(byte[] instruction, File file){
        this.logs = file;
        this.instruction = new byte[instruction.length];
        System.arraycopy(instruction, 0, this.instruction, 0, instruction.length);
    }
    
    public TranslateMessageTask(byte[] instruction, SbinServer server){
        this.instruction = new byte[instruction.length];
        System.arraycopy(instruction, 0, this.instruction, 0, instruction.length);
        this.logs = null;
        this.server = server;
    }

    @Override
    protected Void call() throws Exception {
        if (instruction[0] == 0)
        {
            System.out.println("nowy gracz");
            byte[] message = {0, 1, 1, 1};
            server.addPlayer();
            message[0] = server.getPlayers();
            new SendMessageTask(message).call();
        }
        return null;
    }
     
}
