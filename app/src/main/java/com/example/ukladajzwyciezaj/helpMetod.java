package com.example.ukladajzwyciezaj;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.style.IconMarginSpan;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;

public class helpMetod {
    public static Button getButton(Context context, String string, int color) {
        Button button = new Button(context);
        button.setText(string);
        //int pixels = (int) TypedValue.applyDimension(
        //        TypedValue.COMPLEX_UNIT_DIP, 10f, context.getResources().getDisplayMetrics()
        //);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(pixels, LinearLayout.LayoutParams.WRAP_CONTENT);
        //button.setLayoutParams(params);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(color); // Ustaw kolor tła przycisku
        button.setBackground(gradientDrawable);
        return button;
    }


}
