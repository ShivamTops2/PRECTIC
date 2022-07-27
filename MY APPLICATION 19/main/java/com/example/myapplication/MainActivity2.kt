package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.materialex.FirstFragment
import com.example.materialex.SecondFragment

class MainActivity2 : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var f=FirstFragment()
        var fm:FragmentManager=supportFragmentManager
        var ft:FragmentTransaction=fm.beginTransaction()
        ft.replace(R.id.frmid,f).commit()

        //fragment show
        var f2=SecondFragment()
        var fm2:FragmentManager=supportFragmentManager
        var ft2:FragmentTransaction=fm2.beginTransaction()
        ft2.replace(R.id.frmid2,f2).commit()


    }
}
