package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity2 extends AppCompatActivity
{

    ListView listView;
    List<Model> list;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        list = new ArrayList<>();
        realm = Realm.getInstance(Realm.getDefaultConfiguration());

        realm.beginTransaction();

        RealmResults<Model> results = realm.where(Model.class).findAll();

        for (Model m : results) {
            list.add(m);
        }
         realm.commitTransaction();


        MyAdpter myAdpter = new MyAdpter(getApplicationContext(),list);
        listView.setAdapter(myAdpter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long l) {

                AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Select operations?");
                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                        AlertDialog.Builder alert2=new AlertDialog.Builder(MainActivity2.this);
                        LayoutInflater in= LayoutInflater.from(MainActivity2.this);
                        View view=in.inflate(R.layout.activity_main3,null);

                        EditText edt1=view.findViewById(R.id.edtu1);
                        EditText edt2=view.findViewById(R.id.edtu2);
                        Button btn1=view.findViewById(R.id.btnu1);
                        realm.beginTransaction();



                        edt1.setText(list.get(i2).name);
                        edt2.setText(list.get(i2).pass);


                        realm.commitTransaction();
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                realm.beginTransaction();

                                RealmResults<Model> results=realm.where(Model.class).findAll();

                                String n=edt1.getText().toString();
                                String p=edt2.getText().toString();

                                results.get(i2).setName(n);
                                results.get(i2).setPass(p);

                                Intent i =new Intent(MainActivity2.this,MainActivity2.class);
                                startActivity(i);

                                realm.commitTransaction();

                            }
                        });

                        alert2.setView(view);
                        alert2.show();





                    }

                });
                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        realm.beginTransaction();
                        RealmResults<Model> results=realm.where(Model.class).findAll();
                        results.deleteFromRealm(i2);
                        realm.commitTransaction();

                        Intent i3 =new Intent(MainActivity2.this,MainActivity2.class);
                        startActivity(i3);
                    }
                });
                alert.show();

            }
        });
    }
}