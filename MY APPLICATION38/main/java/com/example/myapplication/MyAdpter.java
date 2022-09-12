package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdpter extends BaseAdapter
{

    Context context;
    List<Model>list;

    MyAdpter(Context context,List<Model>list)
    {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.desing,viewGroup,false);

        TextView txt1=view.findViewById(R.id.txt1);
        TextView txt2=view.findViewById(R.id.txt2);

        txt1.setText(list.get(i).name);
        txt2.setText(list.get(i).pass);

        return view;
    }
}