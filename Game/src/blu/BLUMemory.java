/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blu;


import java.util.PriorityQueue;



/**
 *
 * @author Archax
 */
public class BLUMemory {       
    PriorityQueue<instructionClass> input;
    
    /* add next instructionClass to input */
    public void add(instructionClass instruction){
        input.add(instruction);
    }
    
    /* get next message to send */
    public instructionClass getNextInstruction(){
        return input.poll();
    }

    /* return true if input is empty */
    public boolean isInputEmpty(){
        return input.isEmpty();
    }
    
}
