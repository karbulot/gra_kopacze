/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javafx.concurrent.Task;

/**
 *
 * @author aniej
 */
public class TranslateMessageTask extends Task<Void> {
    KbinServer server;
    byte[] instruction;
    
    public TranslateMessageTask(byte[] instruction, KbinServer server)
    {
        this.instruction = instruction;
        this.server = server;
    }
    
    @Override
    protected Void call() throws Exception {
        if (instruction[0] == instruction[1] && instruction[2] == 1)
        {
            server.getGame().setPlayerNumber(instruction[3]);
        }
        return null;
    }
    
}
