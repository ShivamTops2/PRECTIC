package com.example.xyz

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA


class MainActivity : AppCompatActivity()
{
    lateinit var btn:Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.btn1)



        if (checkSelfPermission(CALL_PHONE) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED )
        {

        }
        else
        {
            requestPermissions(arrayOf(CALL_PHONE, CAMERA), 1)
        }

        btn.setOnClickListener()
        {
            var num="7202960912"
            var i=Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)

        }

    }


}