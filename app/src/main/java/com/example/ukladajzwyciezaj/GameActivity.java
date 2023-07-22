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
    private ImageView chosen_imageView = null;
    private int resIDchosen_imageView;
    Player player1, player2;

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> NamePlayersList = intent.getStringArrayListExtra("NamePlayers");

        try {
            game = new Game(this, NamePlayersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GridView gridView = (GridView) findViewById(R.id.gridview);
        LinearLayout listPlayer = findViewById(R.id.ListPlayer);

        for (int i = 0; i < NamePlayersList.size(); i++) {
            Button buttonPlayer = new Button(this);
            //buttonPlayer.setTag(NamePlayersList.get(i));
            buttonPlayer.setText(NamePlayersList.get(i));
            buttonPlayer.setOnClickListener(new View.OnClickListener() {
                Player ActualPlayer = null;
                Player.ImageAdapter adapter = null;
                @Override
                public void onClick(View v) {

                    if (ActualPlayer != null){
                        ActualPlayer.setImageAdapter(adapter);
                    }
                    String NamePlayer = (String) buttonPlayer.getText();
                    for (Player elem : game.getPlayers()){
                        if (elem.getName() == NamePlayer){
                            adapter = elem.getImageAdapter();
                            gridView.setAdapter(adapter);
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
                    Integer[] placeToKart = game.getPlayers().get(0).getPlaceToKart();
                    placeToKart[position] = resIDchosen_imageView;
                    game.getPlayers().get(0).setPlaceToKart(placeToKart);
                    //Player p = Players.get(0);
                    //Integer[] z = p.getPlaceToKart();
                    linearLayout1.removeView(chosen_imageView);
                    chosen_imageView = null;
                }
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        for (int j=0; j<3; j++){
            ImageView localView = new ImageView(this);
            int localViewresid = game.getPileOfKart().getRandomKartToGame().getImageResource();
            localView.setImageResource(localViewresid);
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

    public void completeCartInHeand(View v){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        int Childcount = linearLayout.getChildCount();
        if (Childcount < 2){
            while (Childcount < 3) {
                ImageView localView = new ImageView(this);
                int resId = getResources().getIdentifier("kart_to_insite", "drawable", getPackageName());
                localView.setImageResource(resId);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                params1.gravity = Gravity.CENTER;
                params1.setMargins(15, 15, 15, 15);
                localView.setLayoutParams(params1);

                localView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                linearLayout.addView(localView);
                Childcount = linearLayout.getChildCount();
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
            }
        }else{
            Toast.makeText(getBaseContext(),"Nie możesz uzupełnić kart", Toast.LENGTH_SHORT).show();
        }
    }

    public void OnclickButtonExxhance(View v){

    }




}