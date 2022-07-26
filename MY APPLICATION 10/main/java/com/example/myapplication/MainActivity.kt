package com.example.myapplication

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.design.*


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1=findViewById(R.id.btn1)

      btn1.setOnClickListener(View.OnClickListener {


          val toast = Toast(this)
          var layoutInflater = LayoutInflater.from(this)
          var view = layoutInflater.inflate(R.layout.toast_design, null)
          toast.view = view
          toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
          toast.duration = Toast.LENGTH_LONG
          toast.show()


      })


    }

    override fun onBackPressed() {

        var alert = AlertDialog.Builder(this)
        var layoutInflater: LayoutInflater = LayoutInflater.from(this)
        var view = layoutInflater.inflate(R.layout.design, null)
        alert.setView(view)

        var edt1:EditText=view.findViewById(R.id.edt1)
       var btn1:Button=view.findViewById(R.id.b1)

       btn1.setOnClickListener()
       {
           var name =edt1.text.toString()
           Toast.makeText(applicationContext,""+name,Toast.LENGTH_LONG).show()
       }
        alert.show()

         var alerts=AlertDialog.Builder(this)
      alert.setTitle("xyz?")
      alert.setPositiveButton("NO",{ dialogInterface: DialogInterface, i: Int ->


      })
      alert.setNegativeButton("YES",{ dialogInterface: DialogInterface, i: Int ->


      })
      alert.setNeutralButton("CANCEL",{ dialogInterface: DialogInterface, i: Int ->


      })

      alert.show()


    }
}





