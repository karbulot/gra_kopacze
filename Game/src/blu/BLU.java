/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blu;

import game.Game;

/**
 *
 * @author Archax
 */
public class BLU implements Runnable{
    
    private final BLUMemory memory;
    private final Game game;

    
    public BLU(BLUMemory memory, Game game){
        this.memory = memory;
        this.game = game;
    }

    @Override
    public void run(){
        boolean quit = false;
        while (!quit){
            while (memory.isInputEmpty());
            this.translate(memory.getNextInstruction());          
        }
    }
    
    void translate(instructionClass message){
        byte[] temp = new byte[8];
        
        switch(message.getInstruction()){
            
        }
              
    }
   

    
}
