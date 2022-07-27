package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.widget.Toolbar

import androidx.viewpager.widget.ViewPager
import com.example.tablayoutex.CallFragment
import com.example.tablayoutex.ChatFragment
import com.example.tablayoutex.MyAdapter
import com.example.tablayoutex.StatusFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{

    lateinit var toolbar: Toolbar
    lateinit var tablayout:TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager=findViewById(R.id.view1)
        setupviewpager()

        tablayout=findViewById(R.id.tab)
        tablayout.setupWithViewPager(viewPager)

    }

    private fun setupviewpager()
    {
        var myAdapter=MyAdapter(supportFragmentManager)
        myAdapter.addfragment("CHAT",ChatFragment())
        myAdapter.addfragment("STATUS",StatusFragment())
        myAdapter.addfragment("CALL",CallFragment())
        viewPager.adapter=myAdapter
    }


}