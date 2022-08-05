package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adpter extends BaseAdapter
{
    Context context;
    List<Model> List;

    Adpter(Context context, List<Model> list)
    {
        this.context = context;
        this.List= list;

    }
    public int getCount()

    {
        return List.size();
    }

    public Object getItem(int i)

    {
        return List.get(i);
    }

    public long getItemId(int i)

    {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.desind,viewGroup,false);

        ImageView img=view.findViewById(R.id.im1);
        TextView txt=view.findViewById(R.id.t1);
        TextView txt1=view.findViewById(R.id.t2);
        TextView txt2=view.findViewById(R.id.t3);



        img.setImageResource(List.get(i).image);
        txt.setText(List.get(i).text);



        return view;
    }
}







