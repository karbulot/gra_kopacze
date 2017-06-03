/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Archax
 */
public class Pit {
    
    private double progress;
    private final int id;
    
    Pit(int id){
        this.progress = 100.0;
        this.id = id;
    }
    
    /* add 'amount' to pit's progress */
    public void setProgress(double amount){
        this.progress += amount;
    }  
    
    public double getProgress(){
        return this.progress;
    }
    
    public int getId(){
        return this.id;
    }
    
    
}
