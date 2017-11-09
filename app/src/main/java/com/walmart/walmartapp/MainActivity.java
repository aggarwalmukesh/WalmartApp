package com.walmart.walmartapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.walmart.walmartapp.Adapter.AdapterRoutes;
import com.walmart.walmartapp.Entities.ClickInterface;
import com.walmart.walmartapp.Entities.ModelRoutes;
import com.walmart.walmartapp.Entities.WalmartApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickInterface{

    RecyclerView recyclerView;
    AdapterRoutes adapter;
    List<ModelRoutes> listRoutes = new ArrayList<>();

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        fetchRoutes();
    }

    public void backPressed(View view) {
        finish();
    }


    @Override
    public void getPosition(int position) {
        Intent i=new Intent(MainActivity.this,RouteDetailActivity.class);
        i.putExtra("route",listRoutes.get(position));
        startActivity(i);
    }

    public void fetchRoutes(){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, "http://www.mocky.io/v2/5808f00d10000005074c6340", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("response",response.toString());
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                try {
                    listRoutes = Arrays.asList(new Gson().fromJson(response.getJSONArray("routes").toString(), ModelRoutes[].class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter = new AdapterRoutes(MainActivity.this, listRoutes, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error while fetching data", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        WalmartApplication.getInstance().addToRequestQueue(request);
    }
}


