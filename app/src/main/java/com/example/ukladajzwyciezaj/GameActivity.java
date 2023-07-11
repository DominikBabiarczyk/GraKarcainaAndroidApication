package com.example.ukladajzwyciezaj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        ArrayList<String> NamePlayersList = intent.getStringArrayListExtra("NamePlayers");
        //HashSet<String> NamePlayers = new HashSet<>(NamePlayersList);
        //TextView textView = (TextView) findViewById(R.id.textView2);
        //String setPlayers = "";
        //for (String elem : NamePlayersList){
        //    setPlayers = setPlayers + elem + " ";
        //}
        //textView.setText(setPlayers);
    }
}