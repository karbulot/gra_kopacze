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
public class Map extends GameObject
{
    public Map()
    {
        name = "Mapa";
        coordinates = new Dimension(0, 0);
    }
    @Override
    public void update() {}
}
