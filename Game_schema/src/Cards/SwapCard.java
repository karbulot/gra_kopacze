/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

/**
 *
 * @author Archax
 */
public class SwapCard extends Cards{
    public SwapCard(){
        this.name.set("Swap");
        this.power = new Power.SwapPower();
    }
}
