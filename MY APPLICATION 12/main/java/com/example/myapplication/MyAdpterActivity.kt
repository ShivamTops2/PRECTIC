package com.example.listdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class MyAdapter(var context:Context,var list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any
    {
        return p0
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        val layoutInflater=LayoutInflater.from(context)
        var view=layoutInflater.inflate(R.layout.design,p2,false)

        var image:ImageView=view.findViewById(R.id.img)
        var txt1:TextView=view.findViewById(R.id.name)
        var txt2:TextView=view.findViewById(R.id.price)
        var txt3:TextView=view.findViewById(R.id.des)

        txt1.setText(list.get(p0).name)
        txt2.setText(list.get(p0).price)
        txt3.setText(list.get(p0).des)
        image.setImageResource(list.get(p0).image)
        return view
    }
}