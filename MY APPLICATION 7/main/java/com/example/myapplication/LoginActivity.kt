package com.example.uicontrolsex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R

class LoginActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        edt1=findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtpass)
        btn1=findViewById(R.id.btn)


        btn1.setOnClickListener()
        {
            var name=edt1.text.toString()
            var pass=edt2.text.toString()

            if(name.length==0 && pass.length==0)
            {
                edt1.setError("Enter your name")
                edt2.setError("Enter your password")
            }
            else if(name.length==0)
            {
                edt1.setError("Enter your name")
            }
            else if(pass.length==0 && pass.length<8)
            {
                edt2.setError("Enter your password")
            }
            else
            {
                if(pass.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Login Success", Toast.LENGTH_LONG).show()

                    val i = Intent(this,LoginActivity::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext,"Login Faill",Toast.LENGTH_LONG).show()
                }

            }

        }
    }
}