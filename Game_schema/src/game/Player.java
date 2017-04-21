/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Cards.Cards;
import Characters.CharacterClass;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Archax
 */
public class Player {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private List<Cards> deck;
    private CharacterClass character;
    private Pits pit;
}
