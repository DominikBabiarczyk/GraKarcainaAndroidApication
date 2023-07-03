package com.example.ukladajzwyciezaj;
import com.example.ukladajzwyciezaj.helpMetod;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.ActionBar;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.res.ColorStateList;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {
    int quantityplayers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickButtonAddPlayer(View v){
        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        LinearLayout linearLayouthorizontal = new LinearLayout(this);
        int spacing = getResources().getDimensionPixelSize(R.dimen.button_spacing);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMarginEnd(spacing);

        TextView textView = helpMetod.getEditText(this);
        linearLayouthorizontal.addView(textView, layoutParams);

        EditText editText = helpMetod.getEditText(this);
        linearLayouthorizontal.addView(editText, layoutParams);
        Button buttondelete = helpMetod.getButtonDelete(this, linearLayout, linearLayouthorizontal);
        
        linearLayouthorizontal.addView(buttondelete, layoutParams);
        Button buttonsubmit = helpMetod.getButtonsubmit(this);

        linearLayouthorizontal.addView(buttonsubmit, layoutParams);
        linearLayout.addView(linearLayouthorizontal);
    }
}