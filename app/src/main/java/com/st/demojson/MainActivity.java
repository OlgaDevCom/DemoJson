package com.st.demojson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView ls;
    private List<events> lsData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls = findViewById(R.id.lst);


    }

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onStart() {
        super.onStart();
        lsData = new ArrayList<>();
          new AsyncTask<Void, Void, Void>() {
              @Override
              protected Void doInBackground(Void... voids) {
                  lsData = getEventsList(getApplicationContext());
                  return null;
              }
              @Override
              protected void onPostExecute(Void aVoid) {
                  super.onPostExecute(aVoid);
                 ls.setAdapter(new AdapterEvents(MainActivity.this,lsData));
              }
          }.execute();

    }
    public List<events> getEventsList(Context context){

        final Type typeOf = new TypeToken<List<events>>() {}.getType();
        String Your_JSON_String = getAssetJsonData(context);
        List<events> map = new ArrayList<>();

        try {
            JSONObject jsonarray = new JSONObject(Your_JSON_String);

            JSONArray arr = jsonarray.getJSONArray("events");

            for (int i=0; i<arr.length(); i++) {

                JSONObject actor = arr.getJSONObject(i);
                events events_ = new events();
                events_.setName(actor.getString("name"));
                events_.setId(actor.getString("id"));
                events_.setActive(actor.getBoolean("active"));
                if(actor.getBoolean("active"))
                map.add(events_);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return map;
    }
    public String getAssetJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("events.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e("data", json);
        return json;

    }
}

