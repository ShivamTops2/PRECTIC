package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class
MainActivity2 extends AppCompatActivity
{
   ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //  this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        View view2=binding.getRoot();
        setContentView(view2);


binding.btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view)
    {
        String number=binding.edt1.getText().toString();
        String pass=binding.edt2.getText().toString();


        if(number.equals("SHIVAM") && pass.equals("1234"))
        {
            Toast.makeText(MainActivity2.this, "Loggedin succesfully", Toast.LENGTH_SHORT).show();

            Intent i =new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(MainActivity2.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }


    }
});



        }


    }

