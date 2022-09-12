package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    List<Model>list;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        list=new ArrayList<>();

        StringRequest stringRequest =new StringRequest(Request.Method.POST, "https://topste.000webhostapp.com/TEST/API/view.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {

                try
                {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        int i5=jsonObject1.getInt("id");
                        String n=jsonObject1.getString("name");
                        String i2=jsonObject1.getString("IMAGES");
                        String i3=jsonObject1.getString("mobail_no");
                        String i4=jsonObject1.getString("email");



                        Model m =new Model();
                        m.setName(n);
                        m.setImage(i2);
                        m.setMobailno(i3);
                        m.setEmail(i4);
                        m.setId(i5);

                        list.add(m);


                    }
                    MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
                    listView.setAdapter(myAdapter);

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}