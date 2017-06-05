/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blu;

import game.Game;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {          
                this.translate(memory.getNextInstruction());
            } catch (UnknownInstructionException ex) {
                Logger.getLogger(BLU.class.getName()).log(Level.SEVERE, null, ex);
                quit = true;
            }
        }
    }
    
    void translate(instructionClass message) throws UnknownInstructionException{
        byte[] temp = new byte[8];
        
        switch(message.getInstruction()){
            case Constants.ADD_TIME:
                break;
                
            case Constants.CHANGE_STATE:
                break;
            
           case Constants.DIG_PC:
                break;
            
           case Constants.DIG_FLAT:
                break;
            
          case Constants.SLOW_TARGET:
                break;
            
          case Constants.SPEED_BOOST:
                break;
            
          case Constants.SWAP:
                break;
                
          default:
              throw new UnknownInstructionException();          
        }
              
    }
   

    
}
