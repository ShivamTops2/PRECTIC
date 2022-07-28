package com.example.xyz

import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn:Button
    lateinit var img:ImageView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn=findViewById(R.id.btn1)
        img=findViewById(R.id.img)

        if(checkSelfPermission(CAMERA)==PackageManager.PERMISSION_GRANTED)
        {

        }
        else
        {
            requestPermissions(arrayOf(CAMERA),1)
        }
        btn.setOnClickListener()
        {
            var i =Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1)
        {
            var b:Bitmap= data!!.extras!!.get("data") as Bitmap
            img.setImageBitmap(b)
        }

    }
}