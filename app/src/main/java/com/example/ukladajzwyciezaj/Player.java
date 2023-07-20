package com.example.ukladajzwyciezaj;

import android.content.Context;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ukladajzwyciezaj.Kart;
import com.example.ukladajzwyciezaj.PileOfKart;

public class Player {
    private PileOfKart pileOfKart;
    private ForwardingAttack informationAttack;
    protected HashMap<Integer, Kart> positionKart;

    private Integer[] placeToKart = new Integer[80];
    private Context context;
    private ImageAdapter imageAdapter;
    private String Name;


    public Player(Context context, String name) throws IOException {
        this.pileOfKart = new PileOfKart(context);
        this.positionKart = new HashMap<>();
        this.informationAttack = new ForwardingAttack();
        this.context = context;
        this.Name = name;
        this.imageAdapter = new ImageAdapter();
        for (int j=0; j<placeToKart.length; j++){
            this.placeToKart[j] = this.context.getResources().getIdentifier("grafika_karty","drawable",this.context.getPackageName());
        }

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

    public String getName() {
        return Name;
    }

    public Integer[] getPlaceToKart() {
        return placeToKart;
    }

    public void setPlaceToKart(Integer[] placeToKart) {
        this.placeToKart = placeToKart;
    }

    public ImageAdapter getImageAdapter() {
        return imageAdapter;
    }

    public void setImageAdapter(ImageAdapter imageAdapter) {
        this.imageAdapter = imageAdapter;
    }

    public class ImageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return placeToKart.length;
        }

        @Override
        public Object getItem(int position) {
            return placeToKart[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(500, 500));

                int desiredWidth = 200; // Dostosuj tę wartość do preferencji
                int desiredHeight = 350; // Dostosuj tę wartość do preferencji
                imageView.setLayoutParams(new GridView.LayoutParams(desiredWidth, desiredHeight));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(16,16,16,16);
                imageView.setImageResource(placeToKart[position]);
            }else {
                imageView = (ImageView) convertView;
            }
            return imageView;
        }
    }

}


