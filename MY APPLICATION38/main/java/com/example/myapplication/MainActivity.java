package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity
{

    EditText edt1,edt2;
    Button btn1,btn2;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        realm=Realm.getInstance(Realm.getDefaultConfiguration());


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name=edt1.getText().toString();
                String pass=edt2.getText().toString();

               realm.beginTransaction();

                Model m=realm.createObject(Model.class);
                m.setName(name);
                m.setPass(pass);

               realm.commitTransaction();
                Toast.makeText(MainActivity.this, "Inseretd", Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);

            }
        });

    }
}