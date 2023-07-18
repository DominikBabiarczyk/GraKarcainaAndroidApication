package com.example.ukladajzwyciezaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    Integer[] placeToKart = new Integer[80];
    Integer[] exchangeKart = new Integer[80];
    private ImageView chosen_imageView = null;
    Player player1, player2;
    ArrayList<Player> Players = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> NamePlayersList = intent.getStringArrayListExtra("NamePlayers");

        for (int i=0; i<NamePlayersList.size(); i++){
            try {
                player1 = new Player(this, NamePlayersList.get(i));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Players.add(player1);
        }

        GridView gridView = (GridView) findViewById(R.id.gridview);
        LinearLayout listPlayer = findViewById(R.id.ListPlayer);
        for (int i = 0; i < NamePlayersList.size(); i++) {
            Button buttonPlayer = new Button(this);
            //buttonPlayer.setTag(NamePlayersList.get(i));
            buttonPlayer.setText(NamePlayersList.get(i));
            buttonPlayer.setOnClickListener(new View.OnClickListener() {
                Player ActualPlayer = null;
                @Override
                public void onClick(View v) {

                    if (ActualPlayer != null){

                    }
                    String NamePlayer = (String) buttonPlayer.getText();
                    for (Player elem : Players){
                        if (elem.getName() == NamePlayer){
                            gridView.setAdapter(elem.getImageAdapter());
                            ActualPlayer = elem;
                        }
                    }
                }
            });
            listPlayer.addView(buttonPlayer);
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public  void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getBaseContext(),"Wybrano kartę nr"+(position+1), Toast.LENGTH_SHORT).show();
                if (chosen_imageView != null) {
                    ImageView clickedImageView = (ImageView) v;
                    clickedImageView.setImageDrawable(chosen_imageView.getDrawable());
                    LinearLayout linearLayout1 = findViewById(R.id.linearLayout);
                    //Player p = Players.get(0);
                    //Integer[] z = p.getPlaceToKart();
                    linearLayout1.removeView(chosen_imageView);
                    chosen_imageView = null;
                }
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        for (int j=0; j<3; j++){
            //ImageView localView = game.getPileOfKart().getRandomKartToGame().getImageView();
            //PileOfKart pileOfKart = game.getPileOfKart();
            //ImageView localView = drawnCard.getImageView();
            ImageView localView = new ImageView(this);
            int resId = getResources().getIdentifier("kart_to_insite", "drawable", getPackageName());
            localView.setImageResource(resId);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1);
            params1.gravity = Gravity.CENTER;
            params1.setMargins(15,15,15,15);
            localView.setLayoutParams(params1);
            localView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            localView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v instanceof ImageView) {
                        Toast.makeText(getBaseContext(),"Wybrano kartę do wstawienia", Toast.LENGTH_SHORT).show();
                        chosen_imageView = (ImageView) v;
                        v.setBackgroundResource(R.drawable.obramowanie);
                    }
                }
            });
            linearLayout.addView(localView);
        }
    }

    public void OnclickButtonExxhance(View v){
        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(player2.getImageAdapter());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public  void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getBaseContext(),"Wybrano kartę nr"+(position+1), Toast.LENGTH_SHORT).show();
                if (chosen_imageView != null) {
                    ImageView clickedImageView = (ImageView) v;
                    clickedImageView.setImageDrawable(chosen_imageView.getDrawable());
                    LinearLayout linearLayout1 = findViewById(R.id.linearLayout);
                    linearLayout1.removeView(chosen_imageView);
                    chosen_imageView = null;
                }
            }
        });
    }




}