package com.example.listdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.myapplication.R

class ListExActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_ex)


        listView=findViewById(R.id.list)
        list=ArrayList()

        list.add(Model(R.drawable.mozzarellapizzamargheritaft,"TV1","14999","it's a tv"))
        list.add(Model(R.drawable.images,"TV2","15999","it's a tv2"))
        list.add(Model(R.drawable.pizza,"TV3","16999","it's a tv3"))
        list.add(Model(R.drawable.margherita,"TV1","14999","it's a tv"))
        list.add(Model(R.drawable.download,"TV2","15999","it's a tv2"))
        list.add(Model(R.drawable.etaliyan,"TV3","16999","it's a tv3"))
        list.add(Model(R.drawable.panir,"TV1","14999","it's a tv"))
        list.add(Model(R.drawable.chainish,"TV2","15999","it's a tv2"))
        list.add(Model(R.drawable.chicken,"TV3","16999","it's a tv3"))

        var myAdapter=MyAdapter(applicationContext,list)
        listView.adapter=myAdapter

    }
}