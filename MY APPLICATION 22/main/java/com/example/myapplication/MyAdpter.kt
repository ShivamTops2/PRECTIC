package com.example.tablayoutex

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.ListFragment

class MyAdapter(fm:FragmentManager) :FragmentStatePagerAdapter(fm)
{
    var listFragment:MutableList<Fragment> = ArrayList()
    var listtitle:MutableList<String> = ArrayList()

    override fun getCount(): Int
    {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment
    {
        return listFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return  listtitle.get(position)
    }

    fun addfragment(list:String,fragment: Fragment)
    {
        listtitle.add(list)
        listFragment.add(fragment)
    }


}