package com.walmart.walmartapp.Entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mukeshgarg on 11/8/2017.
 */

public class ModelRoutes implements Serializable {
    public String id;
    public String name;
    public ArrayList<Stops> stops=new ArrayList<>();
    public String description;
    public boolean accessible;
    public String image;

    public class Stops implements Serializable{
        public String name;
    }
}
