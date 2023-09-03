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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InstructionActivity extends AppCompatActivity {

    int[] pictureFunctionaly = new int[9];
    String[] descriptionFunctionaly = {"a", "v", "f", "w", "b", "m", "q", "d", "b"};
    ListInstructionAdapter adapterCards;
    ListInstructionAdapter adapterFunctionaly;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        InputStream inputStream = this.getResources().openRawResource(R.raw.set_information_about_kart);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<Integer> picture = new ArrayList<>();

        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] actualValue = line.split(";");
            stringBuilder.append(line);
            if (actualValue[0].equals("----name_grafic----")) {
                continue;
            }
            name.add(actualValue[0]);
            description.add(actualValue[1]);
            picture.add(getResources().getIdentifier(actualValue[2], "drawable", getPackageName()));
        }

        /*
        int[] pictureCards = new int[name.size()];
        String[] descriptionCards = new String[name.size()];
        String[] nameCards = new String[name.size()];
         */
        int[] pictureCards = new int[picture.size()];
        for (int j=0; j<description.size(); j++){
            pictureCards[j] = picture.get(j);
        }


        for (int j=0; j<descriptionFunctionaly.length; j++){
            pictureFunctionaly[j] = getResources().getIdentifier("kart_to_insite","drawable", getPackageName());
        }
        adapterCards = new ListInstructionAdapter(this, pictureCards, description.toArray(new String[description.size()]));
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