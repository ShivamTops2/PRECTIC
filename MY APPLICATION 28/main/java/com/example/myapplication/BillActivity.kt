package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class BillActivity : AppCompatActivity()
{
    lateinit var text1:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        val i = intent
        var data=i.getStringExtra("tops")

        text1=findViewById(R.id.txtbill)

        text1.setText(data)




    }

    override fun onBackPressed()
    {

        var alert=AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",
            {
                    dialogInterface: DialogInterface, i: Int ->

                finishAffinity()//app close
                //finish()//current activity

            })
        alert.setNegativeButton("NO",{
                dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()


        })
        alert.show()


    }

}