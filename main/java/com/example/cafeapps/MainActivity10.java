package com.example.cafeapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity
{
    ImageView i1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        i1=findViewById(R.id.img1);

        t1=findViewById(R.id.txt1);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)

            {
                String url="https://www.zomato.com/mobile";
                Intent i =new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });


    }
}