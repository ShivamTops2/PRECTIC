package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var ed1:EditText
    lateinit var chk1: CheckBox

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chk1=findViewById(R.id.chk1)
        ed1=findViewById(R.id.ed1)

        chk1.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
        if(chk1.isChecked)
        {
            ed1.transformationMethod=HideReturnsTransformationMethod.getInstance()

        }
        if(!chk1.isChecked)
        {
            ed1.transformationMethod=PasswordTransformationMethod.getInstance()


        }
    }
}