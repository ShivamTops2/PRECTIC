package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity()

{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ib1.setOnClickListener()
        {
            pb.incrementProgressBy(1)
            100*pb.progress
        }
        ib2.setOnClickListener()
        {
            pb.incrementProgressBy(-1)
            100*pb.progress
        }
    }
}

