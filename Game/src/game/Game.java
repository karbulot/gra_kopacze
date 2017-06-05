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
import blu.Constants;

/**
 *
 * @author Archax
 */
public class Game implements Runnable{

    private final ArrayList<Pit> pits; 
    private final ArrayList<Player> players;
    private long time;
    
    /* game's initiation */
    public Game(int numberOfPlayers){
        this.pits = new ArrayList(numberOfPlayers);
        this.players = new ArrayList(numberOfPlayers);
        for (int i = 1; i <= numberOfPlayers; i++){
            this.pits.add(new Pit(i));
            this.players.add(new Player(i,i));
        }
        this.time = Constants.TIME;
    }
    
    /* change game's time */
    public void setTime(int bonusTime){
        this.time += bonusTime;
    }
    
    /* swap p1 <> p2 */
    public void swapPlayers(int p1, int p2){
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
    
    public void setPlayerSpeed(int id, int bonusPC, int time){
        players.get(players.indexOf(id)).setSpeed(bonusPC, time);
    }
    
    public void setPlayerSpeed(int id, double bonus, int time){
        players.get(players.indexOf(id)).setSpeed(bonus, time);
    } 
    
    public int getPlayersPitId(int playerId){
        return this.players.get(this.players.indexOf(playerId)).getPitId();
    }
    
    public void setPlayerState(int id){
        this.players.get(this.players.indexOf(id)).setState();
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
            while (this.time > 0){
                this.pits.forEach(x -> {
                    try {
                        this.updatePitProgress(x.getId());
                    } catch (PlayerSearchException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                this.players.forEach(x -> {
                    if (x.getBonusTime() > 0){
                        x.setBonusTime();
                        if (x.getBonusTime() == 0){
                            x.setSpeed();
                        }
                    }
                        });
                TimeUnit.SECONDS.sleep(1);
                this.time--;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

}
