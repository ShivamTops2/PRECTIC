package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

public class MainActivity6 extends AppCompatActivity {
    ListView listView2;
    List<Model2> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        listView2 = findViewById(R.id.list3);
        list2= new ArrayList<>();

        list2.add(new Model2(R.drawable.abc, "STYLES.XML!"));


        Adpter2 myadpter = new Adpter2(getApplicationContext(),list2);
        listView2.setAdapter(myadpter);


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

                Toast.makeText(MainActivity6.this, "" + i, Toast.LENGTH_SHORT).show();


                if(i==0)
                {

                    String url="https://www.tutorialspoint.com/android/android_styles_and_themes.htm#:~:text=A%20style%20is%20defined%20in,xml%20extension.";
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