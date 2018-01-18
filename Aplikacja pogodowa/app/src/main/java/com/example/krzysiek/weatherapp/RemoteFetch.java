package com.example.krzysiek.weatherapp;

/**
 * Created by Krzysiek on 18.01.2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


public class RemoteFetch extends AsyncTask<String, Void, JSONObject> {

    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=";
    Context context;
    JSONObject data;

    public RemoteFetch(Context context) {
        this.context = context;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        Log.i("DUPA", "estst");
        try {
            URL url = new URL(OPEN_WEATHER_MAP_API + strings[0] + "&units=metric&appid=" + context.getString(R.string.open_weather_maps_app_id));
            Log.i("CONTENT", strings[0]);

            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            Log.i("CONTENT", "BEGIN");
            while ((tmp = reader.readLine()) != null) {
                Log.i("CONTENT", tmp);
                json.append(tmp).append("\n");
            }
            reader.close();
            Log.i("CONTENT", "END");

            data = new JSONObject(json.toString());

            if (data.getInt("cod") != 200) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}