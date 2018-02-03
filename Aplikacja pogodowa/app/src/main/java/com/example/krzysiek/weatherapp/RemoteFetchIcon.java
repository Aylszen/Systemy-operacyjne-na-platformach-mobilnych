package com.example.krzysiek.weatherapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressLint("StaticFieldLeak")
class RemoteFetchIcon extends AsyncTask<String, Void, byte[]> {
    private final Context context;

    public RemoteFetchIcon(Context context) {
        this.context = context;
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        HttpURLConnection connection;
        InputStream is;
        try {
            connection = (HttpURLConnection) (new URL(context.getString(R.string.open_weather_maps_img) + strings[0] + ".png")).openConnection();
            Log.i("WEATHER", strings[0]);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            Log.i("WEATHER", (context.getString(R.string.open_weather_maps_img) + strings[0] + ".png"));
            is = connection.getInputStream();
            byte[] buffer = new byte[4096];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (is.read(buffer) != -1)
                baos.write(buffer);
            Log.i("WEATHER", String.valueOf(baos.toByteArray().length));
            return baos.toByteArray();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}
