package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_data.*
import java.util.ArrayList

class ListdataActivity : AppCompatActivity()
{
    class ListDataActivity : AppCompatActivity(),
        androidx.appcompat.widget.SearchView.OnQueryTextListener
    {
        lateinit var list: MutableList<String>
        var arrayAdapter: ArrayAdapter<String>? = null

        override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_list_data)

            list = ArrayList()

            list.add("Android")
            list.add("Java")
            list.add("Php")
            list.add("ios")

            arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
            list1.adapter = arrayAdapter

            search.setOnQueryTextListener(this)


        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            /* if (list.contains(query))
             {
                 arrayAdapter!!.filter
             }*/
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean
        {
            if (list.contains(newText))
            {
                arrayAdapter!!.filter.filter(newText)
            }
            return false
        }
    }

}