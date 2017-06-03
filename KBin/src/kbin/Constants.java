/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbin;

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
   public static final int TIME = 60;
}
