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
    
    private boolean quit = false;

    
    public BLU(BLUMemory memory, Game game){
        this.memory = memory;
        this.game = game;
    }

    @Override
    public void run(){
        while (!this.quit){
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(BLU.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!memory.isInputEmpty()){
                try {          
                    this.translate(memory.getNextInstruction());
                } catch (UnknownInstructionException ex) {
                    Logger.getLogger(BLU.class.getName()).log(Level.SEVERE, null, ex);
                    this.quit = true;
            }
            }
        }
    }
    
    void translate(instructionClass message) throws UnknownInstructionException{
        byte[] temp = new byte[8];
        
        switch(message.getInstruction()){
          case Constants.ADD_TIME:
               this.game.setTime(message.getData()[0]);
               break;
                
          case Constants.CHANGE_STATE:
               this.game.setPlayerState(message.getSender());
               break;
            
          case Constants.DIG:
               this.game.setPitProgress(this.game.getPlayersPitId(message.getSender()), message.getData()[0]);
               break;
            
          case Constants.SLOW_TARGET_PC:
               //this.game.setPlayerSpeed(this., 0);
               break;
            
          case Constants.SPEED_BOOST_PC:
               break;
            
          case Constants.SWAP:
               this.game.swapPlayers(message.getSender(), message.getData()[0]);
               break;
               
          case Constants.SPEED_BOOST_FLAT:
               break;
                
          case Constants.SLOW_TARGET_FLAT:
               break;
               
          case Constants.END:
              this.quit = true;
              break;
               
          default:
              throw new UnknownInstructionException();          
        }
              
    }
   

    
}
