package com.example.ukladajzwyciezaj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class InstructionActivity extends AppCompatActivity {
    int[] pictureCards = new int[9];
    String[] descriptionCards = {"a", "v", "f", "w", "b", "m", "q", "d", "b"};

    int[] pictureFunctionaly = new int[9];
    String[] descriptionFunctionaly = {"a", "v", "f", "w", "b", "m", "q", "d", "b"};
    ListInstructionAdapter adapterCards;
    ListInstructionAdapter adapterFunctionaly;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        for (int j=0; j<descriptionCards.length; j++){
            pictureCards[j] = getResources().getIdentifier("grafika_karty", "drawable", getPackageName());
        }

        for (int j=0; j<descriptionFunctionaly.length; j++){
            pictureFunctionaly[j] = getResources().getIdentifier("kart_to_insite","drawable", getPackageName());
        }
        adapterCards = new ListInstructionAdapter(this, pictureCards, descriptionCards);
        adapterFunctionaly = new ListInstructionAdapter(this, pictureFunctionaly, descriptionFunctionaly);
    }

    public void OnClickButtonCards(View v){
        ListView listView = (ListView) findViewById(R.id.listView);
        /*
        Button buttonC = findViewById(R.id.buttonCards);
        Button buttpnF = findViewById(R.id.buttonFuntionaly);
        buttonC.setBackgroundColor(Color.GRAY);
         */
        listView.setAdapter(adapterCards);
    }

    public void OnClickButtonFunctionaly(View v){
        ListView listView = (ListView) findViewById(R.id.listView);
        /*
        Button buttonC = findViewById(R.id.buttonCards);
        Button buttpnF = findViewById(R.id.buttonFuntionaly);
        buttpnF.setBackgroundColor(Color.GRAY);
         */
        listView.setAdapter(adapterFunctionaly);
    }

}