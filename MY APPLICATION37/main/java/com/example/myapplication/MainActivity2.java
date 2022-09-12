package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity
{

    ListView listView;
    List<Model> list;
    DbHelper dbHelper;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        listView=findViewById(R.id.list);
        list=new ArrayList<>();
        dbHelper=new DbHelper(getApplicationContext());

        list= dbHelper.Viewdata();

        for(Model m:list)
        {
            HashMap<String,String>hm=new HashMap<>();
            hm.put("name",m.getName());
            hm.put("number",m.getNumber());

            arrayList.add(hm);

        }

        String from[]={"name","number",};
        int to[]={R.id.txt1,R.id.txt2,};

        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity2.this,arrayList,R.layout.desing,from,to);
        listView.setAdapter(simpleAdapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        MenuItem m1 =menu.add(0,1,0,"Update");
        MenuItem m2 =menu.add(0,2,0,"Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {

        AdapterView.AdapterContextMenuInfo acm= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id=acm.position;
        Model m=list.get(id);
        switch (item.getItemId())
        {
            case 1:
            {
                Intent i =new Intent(MainActivity2.this,UPActivity.class);
                i.putExtra("id",m.getId());
                i.putExtra("name",m.getName());
                i.putExtra("number",m.getNumber());
                startActivity(i);
            }
            break;

            case 2:
            {
                AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Are you sure you want to delete?");
                alert.setPositiveButton("YEs", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dbHelper.deletedata(m.getId());
                        Intent i2 =new Intent(MainActivity2.this,MainActivity2.class);
                        startActivity(i2);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        dialogInterface.cancel();
                    }
                });

                alert.show();
             }
            break;
        }

        return super.onContextItemSelected(item);
    }
}

