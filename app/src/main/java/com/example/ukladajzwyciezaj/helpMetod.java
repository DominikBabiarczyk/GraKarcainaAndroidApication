package com.example.ukladajzwyciezaj;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.style.IconMarginSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;

import java.util.ArrayList;

public class helpMetod {
    public static Button getButtonDelete(Context context, LinearLayout linearLayout, LinearLayout linearLayouthorizontal) {
        Button button = new Button(context);
        button.setText("delete");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(Color.RED); // Ustaw kolor tła przycisku
        button.setBackground(gradientDrawable);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.removeView(linearLayouthorizontal);
            }
        });
        return button;
    }

    public static Button getButtonsubmit(Context context, ArrayList<String> NamePlayers, EditText editText) {
        Button button = new Button(context);
        button.setText("submit");
        //int pixels = (int) TypedValue.applyDimension(
        //        TypedValue.COMPLEX_UNIT_DIP, 10f, context.getResources().getDisplayMetrics()
        //);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(pixels, LinearLayout.LayoutParams.WRAP_CONTENT);
        //button.setLayoutParams(params);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(Color.GREEN); // Ustaw kolor tła przycisku
        button.setBackground(gradientDrawable);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (editText) ((Activity) context).findViewById(R.id.e);
                String text = editText.getText().toString().trim();
                if(text.length() == 0){
                    Toast.makeText(context.getApplicationContext(), "Nie wprowadzono nazwy", Toast.LENGTH_SHORT).show();
                }else{
                    NamePlayers.add(text);
                    //gradientDrawable.setColor(Color.GRAY);
                }
            }
        });
        return button;
    }

    public static EditText getEditText(Context context){
        EditText editText = new EditText(context);
        int maxLength = 15;
        InputFilter[] filters = new InputFilter[] { new InputFilter.LengthFilter(maxLength) };
        editText.setFilters(filters);
        return editText;
    }

    public static TextView getTextView(Context context){
        TextView bigDotTextVIew = new TextView(context);
        bigDotTextVIew.setText("\u2022");
        bigDotTextVIew.setTextSize(30);
        return bigDotTextVIew;
    }


}
