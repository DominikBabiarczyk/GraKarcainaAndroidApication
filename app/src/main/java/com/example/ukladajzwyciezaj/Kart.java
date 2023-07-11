package com.example.ukladajzwyciezaj;

import android.provider.ContactsContract;
import android.widget.ImageView;
import com.example.ukladajzwyciezaj.SideAttack;
import java.util.HashMap;

public class Kart {
    private HashMap<SideAttack, InfluenceKart> ValueAttack;
    private ImageView imageView;

    public Kart(InfluenceKart left, InfluenceKart right, InfluenceKart top, InfluenceKart bottom, ImageView imageView){
        this.ValueAttack = new HashMap<>();
        this.ValueAttack.put(SideAttack.RIGHT, right);
        this.ValueAttack.put(SideAttack.LEFT, left);
        this.ValueAttack.put(SideAttack.TOP, top);
        this.ValueAttack.put(SideAttack.BOTTOM, bottom);
        this.imageView = imageView;
    }

    public HashMap<SideAttack, InfluenceKart> getValueAttack() {
        return ValueAttack;
    }

    public void setValueAttack(HashMap<SideAttack, InfluenceKart> valueAttack) {
        ValueAttack = valueAttack;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
