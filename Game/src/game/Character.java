/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;

/**
 *
 * @author aniej
 */
public class Character extends GameObject {
    public Character()
    {
        this.name = "Kopacz";
    }
    public Character(Dimension coordinates)
    {
        this.name = "Kopacz";
        this.coordinates = coordinates;
    }
    public Character(int x, int y)
    {
        this.name = "Kopacz";
        this.coordinates = new Dimension(x, y);
    }
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
