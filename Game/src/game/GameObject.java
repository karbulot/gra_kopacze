/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author aniej
 */
public abstract class GameObject {
    Dimension coordinates;
    String name;
    public void draw(JPanel jPanel)
    {
        try {
                BufferedImage img = ImageIO.read(new File("src/resources/" + name + ".jpg"));
                jPanel.getGraphics().drawImage(img, coordinates.width, coordinates.height, null);
                System.out.println("narysowalem");
                //bi.drawImage()
        } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
        }
    }
    public abstract void update();
}
