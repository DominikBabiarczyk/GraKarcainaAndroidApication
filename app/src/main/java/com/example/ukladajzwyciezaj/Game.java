package com.example.ukladajzwyciezaj;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private PileOfKart pileOfKart;
    ArrayList<Player> Players;
    private int CurrentPlayerIndex = Integer.MAX_VALUE;

    public Game(Context context,GameActivity gameActivity, ArrayList<String> NamePlayersList) throws IOException {
        this.pileOfKart = new PileOfKart(context, gameActivity);
        this.Players = new ArrayList<>();
        Player player1;
        for (int i=0; i<NamePlayersList.size(); i++){
            try {
                player1 = new Player(context, NamePlayersList.get(i), this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.Players.add(player1);
        }
        this.CurrentPlayerIndex = 0;
    }

    public PileOfKart getPileOfKart() {
        return pileOfKart;
    }

    public void setPileOfKart(PileOfKart pileOfKart) {
        this.pileOfKart = pileOfKart;
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }
    public Player getNextPlayer(){
        if (this.CurrentPlayerIndex >= this.Players.size()-1){
            this.CurrentPlayerIndex = 0;
        }else {
            this.CurrentPlayerIndex = this.CurrentPlayerIndex+1;
        }
        return this.Players.get(this.CurrentPlayerIndex);
    }


}
