package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThFragment extends Fragment
{
    TextView txt2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_th, container, false);


        txt2=view.findViewById(R.id.text2);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Intent i =new Intent(getActivity(),MainActivity3.class);
                startActivity(i);

                /*FristFragment f1 =new FristFragment();//account open
                FragmentManager fm=getFragmentManager();//manager
                FragmentTransaction ft=fm.beginTransaction();//transaction
                ft.replace(R.id.frmid1,f1).commit();
*/

            }
        });

        return view;

    }
}