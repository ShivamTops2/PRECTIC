package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adpter2 extends BaseAdapter
{
    Context context;
    List<Model2> List2;

    Adpter2(Context context, List<Model2> list2)
    {
        this.context = context;
        this.List2 = list2;

    }

    @Override
    public int getCount() {
        return List2.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.desing2,viewGroup,false);

        ImageView im1=view.findViewById(R.id.im2);
        TextView tt1=view.findViewById(R.id.tt2);

        im1.setImageResource(List2.get(i).im2);
        tt1.setText(List2.get(i).tt2);

        return view;
    }


}





