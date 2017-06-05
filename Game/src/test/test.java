/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import blu.*;
import game.Game;

/**
 *
 * @author Archax
 */
public class test {  
    
    public static void main(String[] args){
        BLUMemory memory = new BLUMemory();
        Game game = new Game(3);
        BLU blu = new BLU(memory, game);
        
        game.run();
        System.out.print(game.toString());
        
    }
    
}
