/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import Power.PowerClass;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Archax
 */
public abstract class Cards {
    protected final SimpleStringProperty name = new SimpleStringProperty();
    protected PowerClass power;
    
    public final String getName(){
        return this.name.get();
    }

}
