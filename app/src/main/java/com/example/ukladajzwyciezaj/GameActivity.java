package com.example.ukladajzwyciezaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> NamePlayersList = intent.getStringArrayListExtra("NamePlayers");
        try {
            player1 = new Player(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            player2 = new Player(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        LinearLayout listPlayer = findViewById(R.id.ListPlayer);
        for (int i = 0; i < NamePlayersList.size(); i++) {
            Button buttonPlayer = new Button(this);
            //buttonPlayer.setTag(NamePlayersList.get(i));
            buttonPlayer.setText(NamePlayersList.get(i));
            listPlayer.addView(buttonPlayer);
        }

        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(player1.getImageAdapter());
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