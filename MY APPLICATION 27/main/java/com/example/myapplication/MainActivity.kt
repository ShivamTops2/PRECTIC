package com.example.sqliteex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.ShowActivity

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var db:DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtnum)
        btn1=findViewById(R.id.btninsert)
        btn2=findViewById(R.id.btnview)
        db= DbHelper(this)


        btn1.setOnClickListener()
        {
            var name=edt1.text.toString()
            var num=edt2.text.toString()

            var m=Model()
            m.name=name
            m.num=num

            var id=db.addata(m)

            Toast.makeText(applicationContext,"record inseretd "+id,Toast.LENGTH_LONG).show()
        }

        btn2.setOnClickListener()
        {
            var intent=Intent(this,ShowActivity::class.java)
            startActivity(intent)

        }


    }
}