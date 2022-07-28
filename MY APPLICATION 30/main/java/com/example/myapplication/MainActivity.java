package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    List<String>list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        list =new ArrayList<>();
        searchView=findViewById(R.id.search);


        list.add("Android");
        list.add("Iphone");
        list.add("windows");
        list.add("blackberry");
        list.add("windows2");
        list.add("windows3");
        list.add("awe");

        ArrayAdapter arrayAdapter =new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                  /*  if(list.contains(s))
                    {
                        arrayAdapter.getFilter().filter(s);
                    }*/

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {

                arrayAdapter.getFilter().filter(s);

                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.option,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.i1:

                Toast.makeText(MainActivity.this, "calling", Toast.LENGTH_SHORT).show();

                String num="9999999999";
                Intent i =new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+num));
                startActivity(i);


                break;
        }
        return super.onOptionsItemSelected(item);
    }
}