package com.example.krzysiek.weatherapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Krzysiek on 19.01.2018.
 */

public class RemoteFetchIcon  extends AsyncTask<String, Void, byte[]> {

    Context context;

    public RemoteFetchIcon(Context context) {
        this.context = context;
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        HttpURLConnection connection = null ;
        InputStream is = null;
        try {
            connection = (HttpURLConnection) ( new URL(context.getString(R.string.open_weather_maps_img) + strings[0]  + ".png")).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
          //  connection.setDoOutput(true);
            connection.connect();

            Log.v("ICON",(context.getString(R.string.open_weather_maps_img) + strings[0]  + ".png"));

            is = connection.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ( is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { connection.disconnect(); } catch(Throwable t) {}
        }
        return null;
    }
}
