package com.example.cafeapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1=findViewById(R.id.edt1);
        e2=findViewById(R.id.edt2);
        b1=findViewById(R.id.btn1);

        //validation
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //take value from edittext to variable
                String name=e1.getText().toString();
                String pass=e2.getText().toString();

                if(name.length()==0 && pass.length()==0)
                {
                    e1.setError("please enter name");
                    e2.setError("please enter password");
                }
                else if(name.length()==0)
                {
                    e1.setError("please enter name");
                }
                else if(pass.length()==0)
                {
                    e2.setError("please enter password");
                }
                else
                {
                    if(name.equals("shivu") && pass.equals("9120"))
                    {
                        Toast.makeText(MainActivity.this, "Loggedin Successfully", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong Details", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }


}


