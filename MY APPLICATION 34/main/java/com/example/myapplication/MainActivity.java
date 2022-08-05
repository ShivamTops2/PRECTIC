package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FristFragment f1 =new FristFragment();//account open
        FragmentManager fm=getSupportFragmentManager();//manager
        FragmentTransaction ft=fm.beginTransaction();//transaction
        ft.replace(R.id.frmid1,f1).commit();


    }
}