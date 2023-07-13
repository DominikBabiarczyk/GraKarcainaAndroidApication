package com.example.ukladajzwyciezaj;

import android.content.Context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.ukladajzwyciezaj.Kart;
import com.example.ukladajzwyciezaj.PileOfKart;

public class Player {
    private PileOfKart pileOfKart;
    private ForwardingAttack informationAttack;
    protected HashMap<Integer, Kart> positionKart;


    private View card_grid;


    public Player(Context context) throws IOException {
        this.pileOfKart = new PileOfKart(context);
        this.positionKart = new HashMap<>();
        this.card_grid = LayoutInflater.from(context).inflate(R.layout.card_grid, null);
        this.informationAttack = new ForwardingAttack();

    }

    public void EnterCardToPlay(GridView gridView, Kart kart, Integer position){
        this.positionKart.put(position, kart);
        int numCol = gridView.getNumColumns();
        HashMap<SideAttack, InfluenceKart> attackKart = kart.getValueAttack();
        this.informationAttack.SaveAttack(attackKart.get(SideAttack.RIGHT),position+1, SideAttack.RIGHT);
        this.informationAttack.SaveAttack(attackKart.get(SideAttack.LEFT),position-1, SideAttack.LEFT);
        this.informationAttack.SaveAttack(attackKart.get(SideAttack.TOP),position - numCol, SideAttack.TOP);
        this.informationAttack.SaveAttack(attackKart.get(SideAttack.BOTTOM),position + numCol, SideAttack.BOTTOM);

    }

    public void DeleteKart(GridView gridView, int position){
        this.positionKart.remove(position);
        int numCol = gridView.getNumColumns();
        this.informationAttack.RemoveAttack(position-1, SideAttack.LEFT);
        this.informationAttack.RemoveAttack(position+1, SideAttack.RIGHT);
        this.informationAttack.RemoveAttack(position+numCol, SideAttack.BOTTOM);
        this.informationAttack.RemoveAttack(position-numCol, SideAttack.TOP);
    }

    public PileOfKart getPileOfKart() {
        return pileOfKart;
    }

    public void setPileOfKart(PileOfKart pileOfKart) {
        this.pileOfKart = pileOfKart;
    }
    //public void RemoveKart(GridView gridView, int positionStart, int positionFinish){

    //}

    public View getCard_grid() {
        return card_grid;
    }

}
