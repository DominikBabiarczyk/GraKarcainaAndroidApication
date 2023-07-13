package com.example.ukladajzwyciezaj;

import java.util.HashMap;

public class ForwardingAttack {
    private HashMap<Integer, InfluenceKart> RightAttack;
    private HashMap<Integer, InfluenceKart> LeftAttack;
    private HashMap<Integer, InfluenceKart> TopAttack;
    private HashMap<Integer, InfluenceKart> BottomAttack;

    public ForwardingAttack(){
        this.BottomAttack = new HashMap<>();
        this.LeftAttack = new HashMap<>();
        this.TopAttack = new HashMap<>();
        this.RightAttack = new HashMap<>();
    }

    public void SaveAttack(InfluenceKart powerAttack, int position, SideAttack side){
        switch (side){
            case TOP:
                TopAttack.put(position, powerAttack);

            case LEFT:
                LeftAttack.put(position, powerAttack);

            case RIGHT:
                RightAttack.put(position, powerAttack);

            case BOTTOM:
                BottomAttack.put(position, powerAttack);
        }
    }

    public void RemoveAttack(int position, SideAttack side){
        switch (side){
            case TOP:
                TopAttack.remove(position);

            case LEFT:
                LeftAttack.remove(position);

            case RIGHT:
                RightAttack.remove(position);

            case BOTTOM:
                BottomAttack.remove(position);
        }
    }

}
