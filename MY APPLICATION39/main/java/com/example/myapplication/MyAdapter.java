package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends BaseAdapter
{
    Context context;
    List<Model>list;

    MyAdapter(Context context, List<Model>list)
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
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater in =LayoutInflater.from(context);
        view=in.inflate(R.layout.desing,viewGroup,false);

        TextView txt=view.findViewById(R.id.txt);
        TextView txt1=view.findViewById(R.id.txt1);
        TextView txt2=view.findViewById(R.id.txt2);
        ImageView img=view.findViewById(R.id.i1);

        txt.setText(list.get(i).name);
        txt1.setText(list.get(i).mobailno);
        txt2.setText(list.get(i).email);

        Picasso.get().load(list.get(i).IMAGES).into(img);

        return view;
    }
}