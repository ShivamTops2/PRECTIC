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

public class MainActivity5 extends AppCompatActivity {
    ListView listView1;
    List<Model1> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listView1 = findViewById(R.id.list2);
        list1 = new ArrayList<Model1>();

        list1.add(new Model1(R.drawable.w2, "WHY ANDROID!"));


        Adpter1 myadpter = new Adpter1(getApplicationContext(), list1);
        listView1.setAdapter(myadpter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                  Toast.makeText(MainActivity5.this, "" + i, Toast.LENGTH_SHORT).show();


                 if(i==0)
                {

                    String url="https://www.android.com/intl/en_in/what-is-android/#:~:text=When%20a%20device%20goes%20from,tablets%2C%20Android%20powers%20them%20all.";
                    Intent i2 =new Intent(Intent.ACTION_VIEW);
                    i2.setData(Uri.parse(url));
                    startActivity(i2);
                }
              /*  if(i==1)
                {
                    Intent i1 =new Intent(MainActivity5.this,MainActivity6.class);
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
                }*/

            }
        });


    }

}