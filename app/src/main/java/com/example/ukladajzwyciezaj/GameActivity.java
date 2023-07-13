package com.example.ukladajzwyciezaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class GameActivity extends AppCompatActivity {
    Integer[] placeToKart = new Integer[80];
    Integer[] exchangeKart = new Integer[80];
    private ImageView chosen_imageView = null;
    Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> NamePlayersList = intent.getStringArrayListExtra("NamePlayers");

        try {
            this.player = new Player(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        for (int j=0; j<placeToKart.length; j++){
            placeToKart[j] = getResources().getIdentifier("grafika_karty","drawable",getPackageName());
        }
        for (int j=0; j<exchangeKart.length; j++){
            exchangeKart[j] = getResources().getIdentifier("kart_left_attack_right_defence","drawable",getPackageName());
        }
        //GridView gridView = player.getCard_grid().findViewById(R.id.gridviewdynamic);
        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(new ImageAdapter());
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
                imageView = new ImageView(getBaseContext());
                imageView.setLayoutParams(new GridView.LayoutParams(500, 500));

                int desiredWidth = 200; // Dostosuj tę wartość do preferencji
                int desiredHeight = 350; // Dostosuj tę wartość do preferencji
                imageView.setLayoutParams(new GridView.LayoutParams(desiredWidth, desiredHeight));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(16,16,16,16);
            }else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(placeToKart[position]);
            return imageView;
        }
    }
    public void OnclickButtonExxhance(View v){
        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(new exchanceImageAdapter());
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

    public class exchanceImageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return exchangeKart.length;
        }

        @Override
        public Object getItem(int position) {
            return exchangeKart[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(getBaseContext());
                imageView.setLayoutParams(new GridView.LayoutParams(500, 500));

                int desiredWidth = 200; // Dostosuj tę wartość do preferencji
                int desiredHeight = 350; // Dostosuj tę wartość do preferencji
                imageView.setLayoutParams(new GridView.LayoutParams(desiredWidth, desiredHeight));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(16, 16, 16, 16);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(exchangeKart[position]);
            return imageView;
        }
    }


}