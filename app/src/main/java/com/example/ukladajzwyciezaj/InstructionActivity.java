package com.example.ukladajzwyciezaj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class InstructionActivity extends AppCompatActivity {
    int[] obrazki = new int[7];
    String[] opis = {"a", "v", "f", "w", "b", "m", "q"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        for (int j=0; j<opis.length; j++){
            obrazki[j] = getResources().getIdentifier("grafika_karty", "drawable", getPackageName());
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        ListInstructionAdapter adapter = new ListInstructionAdapter(this, obrazki, opis);
        listView.setAdapter(adapter);

    }
}