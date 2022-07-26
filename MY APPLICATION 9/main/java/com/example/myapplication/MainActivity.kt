package com.example.uiex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rb1.setOnCheckedChangeListener(this)
        rb2.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
        if(rb1.isChecked)
        {
            Toast.makeText(applicationContext,"Male",Toast.LENGTH_LONG).show()
        }
        if(rb2.isChecked)
        {
            Toast.makeText(applicationContext,"Female",Toast.LENGTH_LONG).show()
        }
    }
}