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
public class PlayerSearchException extends Exception{
   @Override
   public String getMessage(){
       return "Can not find the player";
   }   
}
