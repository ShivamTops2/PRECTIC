package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    GridView listView;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.g1);
        list=new ArrayList<>();

        list.add(new Model(R.drawable.im1,"INTRODUCATION"));
        list.add(new Model(R.drawable.im2,"PROJECT"));
        list.add(new Model(R.drawable.im3,"LAYOUTS"));
        list.add(new Model(R.drawable.im4,"UI WIDGETS"));
        list.add(new Model(R.drawable.im5,"MENU"));
        list.add(new Model(R.drawable.im6,"SERVICES"));
        list.add(new Model(R.drawable.im7,"MYSQL AND PHP"));
        list.add(new Model(R.drawable.im8,"NOTIFICATION"));


        Adpter myAdapter=new Adpter(getApplicationContext(),list);
        listView.setAdapter(myAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();

                if(i==0)
                {
                    Intent i1=new Intent(MainActivity.this,MainActivity5.class);
                    startActivity(i1);
                }
                if(i==1)
                {
                    Intent i1 =new Intent(MainActivity.this,MainActivity6.class);
                    startActivity(i1);
                }
                if(i==2)
                {
                    String url="https://www.w3schools.com/java/";
                    Intent i2 =new Intent(Intent.ACTION_VIEW);
                    i2.setData(Uri.parse(url));
                    startActivity(i2);
                }
                if(i==3)
                {
                    String url="https://www.w3schools.com/java/";
                    Intent i2 =new Intent(Intent.ACTION_VIEW);
                    i2.setData(Uri.parse(url));
                    startActivity(i2);
                }

            }
        });

    }
}