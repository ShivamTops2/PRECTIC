package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.sqliteex.DbHelper
import com.example.sqliteex.Model
import com.example.myapplication.ShowActivity

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button
    lateinit var db:DbHelper
    var id=0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1=findViewById(R.id.uedtname)
        edt2=findViewById(R.id.uedtnum)
        btn1=findViewById(R.id.btnupdate)
        db= DbHelper(applicationContext)

        var i=intent
        id=i.getIntExtra("id",101)
        var name=i.getStringExtra("name")
        var number= i.getStringExtra("number")

        edt1.setText(name)
        edt2.setText(number)

        btn1.setOnClickListener()
        {
            var name=edt1.text.toString()
            var num=edt2.text.toString()

            var m=Model()
            m.id=id
            m.name=name
            m.num=num

            var id=db.updatedata(m)

            var i=Intent(this,ShowActivity::class.java)
            startActivity(i)
        }


    }
}

