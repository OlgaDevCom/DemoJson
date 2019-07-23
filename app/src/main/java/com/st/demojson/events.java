package com.st.demojson;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;


public class events {


    private String id;

    private String name;

    private boolean active;

    public events(int String, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public events() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



}
