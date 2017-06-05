/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Archax
 */
public class Game implements Runnable{

    private ArrayList<Pit> pits; 
    private ArrayList<Player> players;
    private long time;
    
    /* game's initiation */
    public Game(int numberOfPlayers){
        this.pits = new ArrayList(numberOfPlayers);
        this.players = new ArrayList(numberOfPlayers);
        for (int i = 1; i <= numberOfPlayers; i++){
            this.pits.add(new Pit(i));
            this.players.add(new Player(i,i));
        }
    }
    
    /* change game's time */
    public void setTime(int bonusTime){
        this.time += bonusTime;
    }
    
    /* swap p1 <> p2 */
    public void swapPlayers(int p1, int p2) throws SwapException {
        int id1 = players.get(players.indexOf(p1)).getPitId();
        int id2 = players.get(players.indexOf(p2)).getPitId();
        
        players.get(players.indexOf(p1)).setPitId(id2);
        players.get(players.indexOf(p2)).setPitId(id1);
    }
    
    public void setPitProgress(int id, int amount){
        pits.get(id).setProgress(amount);
    }
    
    private void updatePitProgress(int id) throws PlayerSearchException{
        Player digger = null;
        for (Player p : players){
            if (p.getPitId() == id){
                digger = p;
                break;
            }
        }
        if (digger == null){
            throw new PlayerSearchException();
        }
        pits.get(id).setProgress(digger.getState() * digger.getSpeed() * 0);
    }
    
    public void setPlayerSpeed(int id, int bonusPC){
        players.get(players.indexOf(id)).setSpeed(bonusPC);
    }
    
    public void setPlayerSpeed(int id, double bonus){
        players.get(players.indexOf(id)).setSpeed(bonus);
    } 
    
    public int getPlayersPitId(int playerId){
        return this.players.get(this.players.indexOf(playerId)).getPitId();
    }
    
    @Override
    public String toString(){
        String s = new String();
        for (Pit p : pits){
            s += p.toString();
        }
        for (Player p : players){
            s += p.toString();
        }
        s += "time " + this.time + "\n";
        return s;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

}
