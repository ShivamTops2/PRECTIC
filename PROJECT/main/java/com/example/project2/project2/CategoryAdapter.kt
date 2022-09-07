package com.example.project2.project2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.content.Intent

import android.widget.Toast

import android.content.DialogInterface

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import com.example.project2.Apiinterface
import com.example.project2.R
import com.squareup.picasso.Picasso

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryAdapter(context: Context, dataList: List<Category_Model>) :
    RecyclerView.Adapter<CategoryAdapter.Myview>() {
    var context: Context
    var dataList: List<Category_Model>
    var api: Apiinterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.design_category, parent, false)
        return Myview(view)
    }

    /* override fun onBindViewHolder(holder: Myview, @SuppressLint("RecyclerView") position: Int) {
     }*/

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class Myview(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView



        init {
            img = itemView.findViewById(R.id.img)


        }
    }

    init {
        this.context = context
        this.dataList = dataList
    }



    override fun onBindViewHolder(holder: Myview, position: Int) {
        Picasso.get().load(dataList[position].image).resize(200,200).into(holder.img)
        holder.img.setOnClickListener()
        {
            var i2 =Intent(context, FullScreenActivity::class.java)
            i2.putExtra("image_position",dataList.get(position).image)
            i2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i2)
        }

    }
}