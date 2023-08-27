package com.example.ukladajzwyciezaj;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Game {
    private PileOfKart pileOfKart;
    ArrayList<Player> Players;
    private int CurrentPlayerIndex = Integer.MAX_VALUE;

    public Game(Context context, GameActivity gameActivity, ArrayList<String> NamePlayersList) throws IOException {
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

    public ArrayList<Integer> Buttle(){
        ArrayList<Integer> kartsToBeRemoved = new ArrayList<>();
        ArrayList<InfluenceKart> attacks = new ArrayList<>(Arrays.asList(InfluenceKart.TRIPLE_ATTACK, InfluenceKart.DOUBLE_ATTACK, InfluenceKart.ATTACK));
        for (Player player : this.Players){
            for (Integer i=0; i<4; i++){
                HashMap<Integer, InfluenceKart> sideAttack = player.getInformationAttack().getSetSideAttack().get(i);
                for (InfluenceKart powerAttack : attacks){
                    for (Map.Entry<Integer, InfluenceKart> entry : sideAttack.entrySet()) {
                        if (!player.getPositionKart().containsKey(entry.getKey())){
                            continue;
                        }
                        Kart attackKart = player.getPositionKart().get(entry.getKey());
                        SideAttack SideToDefense = helpMetod.getSideToCheckDefense(player.getContext(), i);
                        if ((entry.getValue() == powerAttack) && (attackKart.getValueAttack().get(SideToDefense) != InfluenceKart.DEFENSE)){
                            kartsToBeRemoved.add(entry.getKey());
                        }
                    }
                }
            }
        }
        return kartsToBeRemoved;
    }

}
