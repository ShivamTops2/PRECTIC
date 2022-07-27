package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity()
{

    lateinit var toolbar: Toolbar
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar=findViewById(R.id.tool)
        setSupportActionBar(toolbar)
        edt1=findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtpass)
        btn1=findViewById(R.id.btn1)

        toolbar.setLogo(R.mipmap.ic_launcher)
        toolbar.setSubtitle("Last seen")
        toolbar.setNavigationIcon(R.drawable.ic_bastliner_arrow_back_24)
        toolbar.setNavigationOnClickListener(){

            Toast.makeText(applicationContext,"back button pressed",Toast.LENGTH_LONG).show()

        }

        btn1.setOnClickListener()
        {

            var name =edt1.text.toString()
            var pass=edt2.text.toString()

            if(pass.equals("1234"))
            {
                var i =Intent(this,MainActivity2::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }


        }

    }
}

