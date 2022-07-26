package com.example.ui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R


class MainActivity : AppCompatActivity()
{




    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        b1.setOnClickListener()
        {
            var name=edtname.text.toString()
            var pass=edtpass.text.toString()

            if(name.length==0 && pass.length==0)
            {
                edtname.setError("Enter your name")
                edtpass.setError("Enter your password")
            }
            else if(name.length==0)
            {
                edtname.setError("Enter your name")
            }
            else if(pass.length==0 && pass.length<8)
            {
                edtpass.setError("Enter your password")
            }
            else
            {
                if(pass.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                }

            }

        }
    }
    override fun onBackPressed()
    {
        finishAffinity()
    }
}