package com.example.ukladajzwyciezaj;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.ColorInt;

public class helpMetod {
    public static Button getButton(Context context, String string, int color) {
        Button button = new Button(context);
        button.setText(string);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        button.setLayoutParams(params);
        float scale = context.getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (70 * scale + 0.5f);
        button.getLayoutParams().width = dpAsPixels;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.OVAL);
        gradientDrawable.setColor(color); // Ustaw kolor tła przycisku
        button.setBackground(gradientDrawable);
        return button;
    }


}
