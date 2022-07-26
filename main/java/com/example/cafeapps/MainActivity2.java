package com.example.cafeapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
{
     ImageView i1,i2,i3;
     TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        i1 = findViewById(R.id.img1);
        i2 = findViewById(R.id.img2);
        i3 = findViewById(R.id.img3);

        t1=findViewById(R.id.txt1);
        t2=findViewById(R.id.txt2);
        t3=findViewById(R.id.txt3);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity2.this, "PIZZA", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity2.this, "PANJABI", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(i);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity2.this, "CHAINISH", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(i);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //explicit
                Intent i =new Intent(MainActivity2.this,MainActivity7.class);
                startActivity(i);


            }
        });


    }
    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity2.this);
        alert.setTitle("Are you sure you want to exit?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        finishAffinity();
                    }

                });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.cancel();
            }
        });

        alert.show();

    }
}









































