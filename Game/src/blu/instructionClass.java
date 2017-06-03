/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blu;

/**
 *
 * @author Archax
 */
public class instructionClass {
    
    private final byte priority;
    private final byte instruction;
    private final byte[] sender;
    private final byte[] data;
    
    public instructionClass(){
        this.priority = 1;
        
        this.instruction = 1;

        this.sender = new byte[3];
        this.sender[0] = 1;
        this.sender[1] = 1;    
        this.sender[2] = 1;
        
        this.data = new byte[3];
        this.data[0] = 1;
        this.data[1] = 1;    
        this.data[2] = 1;
    }
    
    public instructionClass(byte priority){
        this.priority = priority;
        
        this.instruction = 1;

        this.sender = new byte[3];
        this.sender[0] = 1;
        this.sender[1] = 1;    
        this.sender[2] = 1;
        
        this.data = new byte[3];
        this.data[0] = 1;
        this.data[1] = 1;    
        this.data[2] = 1;
    }
    
    public instructionClass(byte[] instruction){
        this.priority = instruction[0];    
        
        this.instruction = instruction[4];
        
        this.sender = new byte[3];
        this.sender[0] = instruction[1];
        this.sender[1] = instruction[2];    
        this.sender[2] = instruction[3];
        
        this.data = new byte[3];
        this.data[0] = instruction[5];
        this.data[1] = instruction[6];    
        this.data[2] = instruction[7];
    }

    public byte getInstruction(){
        return instruction;
    }
    
    int getPriority(){
        return priority;
    }
}
