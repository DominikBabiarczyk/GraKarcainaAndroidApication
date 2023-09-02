package com.example.ukladajzwyciezaj;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;

public class ListInstructionAdapter extends ArrayAdapter {
    Activity activity;
    String[] description;
    int[] picture;
    public ListInstructionAdapter(Activity a, int[] pi, String[] de){
        super(a, R.layout.card_instruction, Collections.singletonList(pi));
        activity = a;
        picture = pi;
        description = de;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowVIew;
        if (convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            rowVIew = inflater.inflate(R.layout.card_instruction, parent, false);
        }
        else {
            rowVIew = convertView;
        }
        ImageView imageView = (ImageView) rowVIew.findViewById(R.id.imageView);
        TextView textView1 = (TextView) rowVIew.findViewById(R.id.textView1);
        TextView textView2 = (TextView) rowVIew.findViewById(R.id.textView2);

        imageView.setImageResource(picture[position]);
        textView1.setText(description[position]);
        textView2.setText(description[position]);
        return rowVIew;
    };


}