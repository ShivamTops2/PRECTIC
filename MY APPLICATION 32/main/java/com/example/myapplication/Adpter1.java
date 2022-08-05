package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adpter1 extends BaseAdapter
{
    Context context;
    List<Model1> List1;

    Adpter1(Context context, List<Model1> list1)
    {
        this.context = context;
        this.List1= list1;

    }


    @Override
    public int getCount() {
        return List1.size();
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
        view=in.inflate(R.layout.desing1,viewGroup,false);

        ImageView im1=view.findViewById(R.id.im1);
        TextView tt1=view.findViewById(R.id.tt1);

        im1.setImageResource(List1.get(i).im1);
        tt1.setText(List1.get(i).tt1);

        return view;
    }


}





