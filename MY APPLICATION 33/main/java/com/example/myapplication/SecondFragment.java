package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment
{

    TextView txt1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);


        txt1=view.findViewById(R.id.txt1);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                  /* Intent i =new Intent(getActivity(),MainActivity.class);
                    startActivity(i);*/


                FristFragment f1 =new FristFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frm1,f1).commit();

            }
        });


        return view;
    }
}