package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var txt1:TextView
    lateinit var btn2:Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)

        txt1=findViewById(R.id.txt1)
        btn2=findViewById(R.id.btn2)
        //Toast.makeText(applicationContext,"welcome "+sharedPreferences.getString("name","tops"),Toast.LENGTH_LONG).show()
        txt1.setText("welcome "+sharedPreferences.getString("name","shivu application"))

        btn2.setOnClickListener()
        {
            sharedPreferences.edit().clear().commit()
            val intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
