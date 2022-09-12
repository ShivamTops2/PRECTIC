package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UPActivity extends AppCompatActivity
{

    EditText edt1,edt2;
    Button btninsert,btnview;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upactivity);

        edt1=findViewById(R.id.edtuname);
        edt2=findViewById(R.id.edtunum);
        btninsert=findViewById(R.id.btnupdate);

        dbHelper=new DbHelper(getApplicationContext());

        Intent i =getIntent();
        int id= i.getIntExtra("id",000);
        edt1.setText(i.getStringExtra("name"));
        edt2.setText(i.getStringExtra("number"));
        Toast.makeText(UPActivity.this, ""+id, Toast.LENGTH_SHORT).show();

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name=edt1.getText().toString();
                String number=edt2.getText().toString();

                Model m =new Model();
                m.setId(id);
                m.setName(name);
                m.setNumber(number);
                dbHelper.updatedata(m);

                Intent i =new Intent(UPActivity.this,MainActivity2.class);
                startActivity(i);

            }
        });


    }
}