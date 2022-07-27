package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WebviweActivity : AppCompatActivity()

{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webviwe)


        wed.loadUrl("https://github.com/siyamed/android-shape-imageview")


    }
}

