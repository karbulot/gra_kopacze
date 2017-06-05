/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blu;

/**
 *
 * @author adam
 */
public class Constants {
   private static Constants instance = null;
   protected Constants(){}
   public static Constants getInstance() {
       if (instance == null){
           instance = new Constants();
       }
       return instance;
   }
   
   public static final int TIME = 300;
   
   public static final int ADD_TIME = 1;
   public static final int SWAP = 2;
   public static final int SLOW_TARGET = 3;
   public static final int DIG_FLAT = 4;
   public static final int DIG_PC = 5;
   public static final int SPEED_BOOST = 6;
   public static final int CHANGE_STATE = 7;
   
}
