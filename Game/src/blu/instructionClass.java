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
    private final byte sender;
    private final byte[] data;
    
    public instructionClass(){
        this.priority = 1;
        
        this.instruction = 1;
        
        this.sender = 1;
        
        this.data = new byte[3];
        this.data[0] = 1;
        this.data[1] = 1;    
        this.data[2] = 1;
    }
    
    public instructionClass(byte priority){
        this.priority = priority;
        
        this.instruction = 1;

        this.sender = 1;
        
        this.data = new byte[3];
        this.data[0] = 1;
        this.data[1] = 1;    
        this.data[2] = 1;
    }
    
    public instructionClass(byte[] instruction){
        this.priority = instruction[0];    
        
        this.instruction = instruction[5];
        
        this.sender = instruction[1];
        
        this.data = new byte[3];
        this.data[0] = instruction[2];
        this.data[1] = instruction[3];    
        this.data[2] = instruction[4];
    }

    public byte getInstruction(){
        return instruction;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public byte[] getData(){
        return this.data;
    }
    
    public byte getSender(){
        return this.sender;
    }
}
