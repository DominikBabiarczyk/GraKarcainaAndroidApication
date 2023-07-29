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
    Kart chosen_kart = null;
    Game game;
    private Player CurrentPlayer = null;

    public Kart getChosen_kart() {
        return chosen_kart;
    }

    public void setChosen_kart(Kart chosen_kart) {
        this.chosen_kart = chosen_kart;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> NamePlayersList = intent.getStringArrayListExtra("NamePlayers");

        try {
            game = new Game(this,this, NamePlayersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GridView gridView = findViewById(R.id.gridview);
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
                            gridView.setAdapter(elem.getImageAdapter());
                            ActualPlayer = elem;
                            CurrentPlayer = elem;
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
                if (chosen_kart != null) {
                    ImageView clickedImageView = (ImageView) v;
                    ImageView chosen_imageView = chosen_kart.getImageView();
                    clickedImageView.setImageDrawable(chosen_imageView.getDrawable());
                    LinearLayout linearLayout1 = findViewById(R.id.linearLayout);
                    linearLayout1.removeView(chosen_imageView);
                    CurrentPlayer.EnterCardToPlay(gridView, chosen_kart,position);
                    chosen_kart = null;
                }
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        for (int j=0; j<3; j++){
            ImageView localView = game.getPileOfKart().getRandomKartToGame().getImageView();
            linearLayout.addView(localView);
        }
    }

    public void completeCartInHeand(View v){
        /*
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        int Childcount = linearLayout.getChildCount();
        if (Childcount < 2 ) {
            while (Childcount < 3) {
                if (game.getPileOfKart().size() < 1){
                    Toast.makeText(getBaseContext(),"Koniec kart w tali", Toast.LENGTH_SHORT).show();
                    break;
                }
                ImageView localView = game.getPileOfKart().getRandomKartToGame().getImageView();
                linearLayout.addView(localView);
                Childcount = linearLayout.getChildCount();
            }
        }else{
            Toast.makeText(getBaseContext(),"Nie możesz uzupełnić kart", Toast.LENGTH_SHORT).show();
        }

         */
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        if(CurrentPlayer!=null) {
            CurrentPlayer.completeCartInHeand(game);
            //CurrentPlayer.SetViewLinearlayout(linearLayout);
        }
    }



    public void OnclickButtonExxhance(View v){
        Toast.makeText(getBaseContext(),"test", Toast.LENGTH_SHORT).show();
    }




}