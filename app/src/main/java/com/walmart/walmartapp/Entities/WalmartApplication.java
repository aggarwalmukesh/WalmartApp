package com.walmart.walmartapp.Entities;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by mukeshgarg on 11/8/2017.
 */

public class WalmartApplication extends Application{

    private static WalmartApplication ourInstance = new WalmartApplication();

    Context context;
    RequestQueue requestQueue;
    public static WalmartApplication getInstance() {
        return ourInstance;
    }


    public WalmartApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance=this;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public void addToRequestQueue(Request request){
        getRequestQueue().add(request);
    }
}
