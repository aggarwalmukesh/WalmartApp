package com.walmart.walmartapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.walmart.walmartapp.Adapter.AdapterStops;
import com.walmart.walmartapp.Entities.ModelRoutes;

public class RouteDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageAccessible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ModelRoutes route= (ModelRoutes) getIntent().getSerializableExtra("route");
        TextView tvTitle= (TextView) findViewById(R.id.txtTitle);
        imageAccessible= (ImageView) findViewById(R.id.imageAccessible);
        TextView txtDescription= (TextView) findViewById(R.id.tvDesc);
        ImageView image= (ImageView) findViewById(R.id.image);
        tvTitle.setText(route.name);
        txtDescription.setText(route.description);
        Glide.with(RouteDetailActivity.this).load(route.image).into(image);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(RouteDetailActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new AdapterStops(RouteDetailActivity.this,route.stops));

        if(route.accessible){
            imageAccessible.setVisibility(View.VISIBLE);
        }else{
            imageAccessible.setVisibility(View.GONE);
        }

    }
}
