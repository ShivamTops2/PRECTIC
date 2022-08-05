package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity
{
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        SecondFragment f1 =new SecondFragment();
        ThFragment i1= new ThFragment();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                replacer2(f1);


            }
        });

       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
               replacer(i1);

           }
       });


    }

    void replacer(Fragment fr){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frm,fr).commit();

    }
    void replacer2(Fragment fr){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frm1,fr).commit();

    }
}