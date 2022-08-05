package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity
{
    ListView listView;
    List<Modal> list;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
      //  this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listView=findViewById(R.id.list1);
        list=new ArrayList<>();


        list.add(new Modal(R.drawable.images,"INSTAGRAM"));
        list.add(new Modal(R.drawable.whatapp,"WHATAPP"));
        list.add(new Modal(R.drawable.a1,"FACEBOOK"));
        list.add(new Modal(R.drawable.sss,"TWITTER"));
        list.add(new Modal(R.drawable.sanp,"SANP"));
        list.add(new Modal(R.drawable.telegtam,"TELEGRAM"));



        MyAdpter myAdapter=new MyAdpter(getApplicationContext(),list);
        listView.setAdapter(myAdapter);

    }

    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity3.this);
        alert.setTitle("Are you sure you want to exit?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                finishAffinity();
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();
            }
        });

        alert.show();




    }
}








