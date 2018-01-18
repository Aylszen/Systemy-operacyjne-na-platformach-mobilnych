package com.example.krzysiek.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewDebug;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private TextView cityText;
    private TextView temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String city = this.getIntent().getStringExtra("CITY");
        cityText = findViewById(R.id.textView2);
        JSONObject data;
        data = new RemoteFetch(getApplicationContext()).execute(city).get();
            temperature  = findViewById(R.id.current_temperature_field);
            //Log.i("MAIN", ("" + data.getInt("main")));
            JSONObject mainObj = data.getJSONObject("main");
            //temperature.setText (Integer.parseInt(jArr.getInt("temp")));
            Log.i("MAIN", valueOf(mainObj.getDouble("temp")));
            temperature.setText (String.valueOf((mainObj.getDouble("temp"))));

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //temperature.setText(Double.toString(data.getDouble("temp")));


         //   Log.v("DUPA", data.getString("cod") );

        // System.out.println(Double.toString(data.getDouble("temp")));




    }
}