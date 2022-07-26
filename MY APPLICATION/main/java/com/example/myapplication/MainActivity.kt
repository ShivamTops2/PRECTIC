package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity :    AppcomponentActivity()
{
    lateinit var t1:TextView
    lateinit var t2:TextView
    lateinit var i1:ImageView
    lateinit var i2:ImageView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        t1=findViewById(R.id.text)
        t2=findViewById(R.id.text2)
        i1=findViewById(R.id.image1)
        i2=findViewById(R.id.image2)

        t1.setOnClickListener()
        {
            Toast.makeText(applicationContext,"IN",Toast.LENGTH_LONG).show()
        }
        t2.setOnClickListener()
        {
            Toast.makeText(applicationContext,"AUS",Toast.LENGTH_LONG).show()
        }
        i1.setOnClickListener()
        {
           Toast.makeText(this,"australia",Toast.LENGTH_LONG).show()
        }
        i2.setOnClickListener()
        {
            Toast.makeText(this,"india",Toast.LENGTH_LONG).show()
        }
        }

    }
