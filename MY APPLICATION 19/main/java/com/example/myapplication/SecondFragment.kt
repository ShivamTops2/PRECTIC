package com.example.materialex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.MainActivity
import com.example.myapplication.R


class SecondFragment : Fragment() {

    lateinit var txt1:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View?
    {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_second, container, false)

        txt1=view.findViewById(R.id.txt2)
        txt1.setOnClickListener()
        {
            var i =Intent(activity,MainActivity::class.java)
            startActivity(i)
        }

        return view
    }


}