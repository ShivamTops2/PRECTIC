package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=new LinearLayout(this);
        TextView txt1=new TextView(this);
        txt1.setText("Hello From Tops");
        int width=LinearLayout.LayoutParams.MATCH_PARENT;
        int height=LinearLayout.LayoutParams.WRAP_CONTENT;

        linearLayout.addView(txt1,width,height);
        setContentView(linearLayout);



    }
}