package com.example.uicontrolsex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.myapplication.BillActivity
import com.example.myapplication.R
import java.lang.StringBuilder

class MainActivity : AppCompatActivity()
{
    //declaration
    lateinit var c1:CheckBox
    lateinit var c2:CheckBox
    lateinit var c3:CheckBox
    lateinit var b1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization
        c1 =findViewById(R.id.chk1)
        c2 =findViewById(R.id.chk2)
        c3 =findViewById(R.id.chk3)
        b1 =findViewById(R.id.btnorder)


        //click event
        b1.setOnClickListener()
        {
            var amount=0
            var builder =StringBuilder()
            builder.append("\n selected Items \n")

            if(c1.isChecked)
            {
                amount+=100
                builder.append("\n Pizza @rs.100 \n ")
            }
            if(c2.isChecked)
            {
                amount+=50
                builder.append("\n Burger @rs.50 \n")
            }
            if(c3.isChecked)
            {
                amount+=120
                builder.append("\n Coffee @rs.120 \n")
            }

            builder.append("\n Bill is \n"+amount)

            //Toast.makeText(applicationContext," \n "+builder.toString(),Toast.LENGTH_LONG).show()


            //putextra,getextra
            val i =Intent(this,BillActivity::class.java)
            i.putExtra("tops",builder.toString())
            startActivity(i)


        }


    }

}