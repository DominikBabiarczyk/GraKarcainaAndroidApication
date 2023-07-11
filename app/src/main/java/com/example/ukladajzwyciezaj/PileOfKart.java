package com.example.ukladajzwyciezaj;
import com.example.ukladajzwyciezaj.Kart;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class PileOfKart{
    private ArrayList<Kart> setAllKart;
    private Context context;

    public PileOfKart(Context context) throws IOException {
        this.context = context;
        this.setAllKart = new ArrayList<>();

        InputStream inputStream = context.getResources().openRawResource(R.raw.set_information_about_kart);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        ImageView KartView = new ImageView(context);

        while ((line = bufferedReader.readLine()) != null) {
            String[] actualValue = line.split(";");
            stringBuilder.append(line);
            if(actualValue[0].equals("------name-----")){
                continue;
            }

            int resId = this.context.getResources().getIdentifier(actualValue[0], "drawable", context.getPackageName());
            KartView.setImageResource(resId);

            Kart kart = new Kart(InfluenceKart.valueOf(actualValue[3]),InfluenceKart.valueOf(actualValue[1]),
                    InfluenceKart.valueOf(actualValue[2]), InfluenceKart.valueOf(actualValue[4]), KartView);

            this.setAllKart.add(kart);
        }

        // Zamknięcie strumieni
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }

    public Kart getRandomKartToGame(){
        if (!this.setAllKart.isEmpty()) {
            int howManyRandom = setAllKart.size();
            Random rand = new Random();
            int randint = rand.nextInt(howManyRandom) + 1;

            Kart removeKart = this.setAllKart.remove(randint - 1);
            return removeKart;
        }
        return null;
    }

    public boolean isEmpty(){
        return this.setAllKart.isEmpty();
    }

    public int quantityKart(){
        return this.setAllKart.size();
    }

}
