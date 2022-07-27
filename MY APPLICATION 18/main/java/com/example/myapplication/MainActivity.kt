package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{
     lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:AppCompatButton
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.uname)
        edt2=findViewById(R.id.upass)
        btn1=findViewById(R.id.btn1)
        sharedPreferences=getSharedPreferences("user_session",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("name", "")!!.isEmpty())
        {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
            finish()
        }


        btn1.setOnClickListener()
        {
            var name=edt1.text.toString()
            var pass=edt2.text.toString()

            if(pass.equals("shivu123"))
            {
                var editor:SharedPreferences.Editor=sharedPreferences.edit()
                editor.putString("name",name)
                editor.putString("pass",pass)
                sharedPreferences.edit().putBoolean("user_session",true).commit();
                editor.apply()
                editor.commit()
                val intent= Intent(applicationContext,MainActivity2::class.java)
                startActivity(intent)

            }
            else
            {
                Snackbar.make(it,"Password is wrong",Snackbar.LENGTH_LONG).show()
            }
        }

    }
}
