package com.example.recyclecard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recycler)

        var manager:RecyclerView.LayoutManager=LinearLayoutManager(this)
        recyclerView.layoutManager=manager

        list=ArrayList()

        list.add(Model(R.drawable.ic_launcher_background,"abcd"))
        list.add(Model(R.drawable.ic_launcher_background,"abcd"))
        list.add(Model(R.drawable.ic_launcher_background,"abcd"))
        list.add(Model(R.drawable.ic_launcher_background,"abcd"))
        list.add(Model(R.drawable.ic_launcher_background,"abcd"))

        var myAdapter=MyAdapter(applicationContext,list)
        recyclerView.adapter=myAdapter







    }
}