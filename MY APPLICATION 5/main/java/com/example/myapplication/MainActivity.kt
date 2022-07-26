package com.example.uiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity()
{

    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_table)

        linearLayout= LinearLayout(this)

        var txt1=TextView(this)
        var txt2=TextView(this)

        txt1.setText("Abcd")

        var width=500
        var height=250

        linearLayout.addView(txt1,width,height)

        setContentView(linearLayout)
    }
}