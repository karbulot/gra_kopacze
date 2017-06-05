/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Archax
 */
public class Player implements Comparable<Integer>{
    
    private final int id;
    private int pitId;
    private double speed;
    private int state; // 1 - digging; -1 - digging-in 
    
    Player(int id, int pitId){
        this.id = id;
        this.pitId = pitId;
        this.state = 1;
    }
    
    /* change pitId to newId */
    public void setPitId(int newId){
        this.pitId = newId;
    }
    
    public int getPitId(){
        return this.pitId;
    }
    
    public int getId(){
        return this.id;
    }
    
    public int getState(){
        return this.state;
    }
    
    public double getSpeed(){
        return this.speed / 100;
    }
    
    /* add bonus (flat) to dig speed */
    public void setSpeed(double bonus){
        this.speed += bonus;
    }
    
    /* add bonus (percent [int]) to dig speed */
    public void setSpeed(int bonusPC){
        this.speed += (this.speed / 100) * bonusPC;
    }

    @Override
    public int compareTo(Integer o) {
        if (this.id == o){
            return 0;
        } else{
            return 1;
        }
    }

    /* change state for opposed */
    public void setState(){
        this.state *= -1;
    }
    
    @Override
    public String toString(){
        return "Player " + this.id +" Pit " + this.pitId + " state " + this.state +" speed " + this.speed + "\n";
    }
    
}
