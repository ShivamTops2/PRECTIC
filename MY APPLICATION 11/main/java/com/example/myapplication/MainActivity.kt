package com.example.menuex

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.example.myapplication.R


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(t1)
        btn1.setOnClickListener()
        {
            val popupMenu=PopupMenu(this,btn1)

            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(object :PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(item: MenuItem?): Boolean
                {
                    when(item!!.itemId)
                    {
                        R.id.popup1->
                        {
                            Toast.makeText(applicationContext,"abcd",Toast.LENGTH_LONG).show()
                        }
                    }
                    return true


                }


            })


            popupMenu.show()

        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"calling",Toast.LENGTH_LONG).show()

                var num="7202960912"
                val i =Intent(Intent.ACTION_CALL)
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)
            }
        }


        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context_menu,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,"position called",Toast.LENGTH_LONG).show()
            }

        }


        return super.onContextItemSelected(item)
    }

}