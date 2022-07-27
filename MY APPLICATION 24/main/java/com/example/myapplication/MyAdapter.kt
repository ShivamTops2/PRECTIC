package com.example.recyclecard

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyAdapter(var context: Context, var list: MutableList<Model>) :RecyclerView.Adapter<MyAdapter.MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyView
    {
        var layout=LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.img.setImageResource(list.get(position).img1)
        holder.text.setText(list.get(position).text1)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    inner class MyView(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        lateinit var img:ImageView
        lateinit var text:TextView

        init
        {
            img=itemView .findViewById(R.id.img)
            text=itemView.findViewById(R.id.txt)
        }


    }


}