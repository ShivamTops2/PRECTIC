package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText edt1,edt2,edt3;
    Button btninsert,btnview;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edtname);
        edt2=findViewById(R.id.edtnum);

        btninsert=findViewById(R.id.btninsert);
        btnview=findViewById(R.id.btnview);
        dbHelper=new DbHelper(getApplicationContext());

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edt1.getText().toString();
                String number=edt2.getText().toString();


                Model m =new Model();
                m.setName(name);
                m.setNumber(number);
                long status= dbHelper.Savedata(m);

                Toast.makeText(MainActivity.this, "Record inserted"+status, Toast.LENGTH_SHORT).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

    }
}


