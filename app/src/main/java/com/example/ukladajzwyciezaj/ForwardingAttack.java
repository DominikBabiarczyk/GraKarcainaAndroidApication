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
                break;

            case LEFT:
                LeftAttack.put(position, powerAttack);
                break;

            case RIGHT:
                RightAttack.put(position, powerAttack);
                break;

            case BOTTOM:
                BottomAttack.put(position, powerAttack);
                break;
        }
    }

    public void RemoveAttack(int position, SideAttack side){
        switch (side){
            case TOP:
                TopAttack.remove(position);
                break;

            case LEFT:
                LeftAttack.remove(position);
                break;

            case RIGHT:
                RightAttack.remove(position);
                break;

            case BOTTOM:
                BottomAttack.remove(position);
                break;
        }
    }

}
