package com.example.listdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.myapplication.R

class MainActivity : AppCompatActivity()/*, AdapterView.OnItemClickListener*/ {
    lateinit var listView: ListView
    lateinit var list:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.list)
        list=ArrayList()


        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("ios")

        var arrayAdapter=ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=arrayAdapter

        registerForContextMenu(listView)
        //listView.setOnItemClickListener(this)

    }

    /* override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long)
     {
        Toast.makeText(applicationContext,""+list.get(p2),Toast.LENGTH_LONG).show()
     }*/

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm=item.menuInfo as AdapterView.AdapterContextMenuInfo
        var id=acm.position

        when(item.itemId)
        {
            com.google.android.material.R.id.position->
            {
                Toast.makeText(applicationContext,""+list.get(id),Toast.LENGTH_LONG).show()

                if(id==0)
                {

                }
                if(id==1)
                {

                }
                if(id==2)
                {

                }

            }
        }
        return super.onContextItemSelected(item)
    }
}