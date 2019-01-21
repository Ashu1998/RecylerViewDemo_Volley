package com.tinkerbyte.recylerviewdemo_volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    final private String Url = "https://api.github.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecylerDemo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StringRequest myrequest = new StringRequest(Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson myGson = gsonBuilder.create();
                UserList[] users= myGson.fromJson(response,UserList[].class);
                recyclerView.setAdapter(new myAdapter(MainActivity.this,users));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Somethinng Wrong",Toast.LENGTH_SHORT).show();


            }
        });
        RequestQueue myQueue = Volley.newRequestQueue(this);
        myQueue.add(myrequest);
    }
}
