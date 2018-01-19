package com.example.krzysiek.weatherapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String city = this.getIntent().getStringExtra("CITY");
            TextView cityText = findViewById(R.id.city_field);
            TextView temperature = findViewById(R.id.current_temperature_field);
            ImageView icon = findViewById(R.id.icon);
            TextView description = findViewById(R.id.description);
            TextView pressure = findViewById(R.id.pressure);
            TextView humidity = findViewById(R.id.humidity);

            JSONObject data = new RemoteFetchWeather(getApplicationContext()).execute(city).get();
            Weather weather = ParseJSON.parse(getApplicationContext(), data);

            String celsius = " ℃";
            temperature.setText (weather.temp + celsius);
        cityText.setText(weather.cityName);
        Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
        icon.setImageBitmap(img);
        description.setText(weather.description);
            String hPa = " hPa";
            pressure.setText(getApplicationContext().getString(R.string.pressure) + " " + weather.pressure + hPa);
            String percent = " %";
            humidity.setText(getApplicationContext().getString(R.string.humidity) + " " + weather.humidity + percent);

        } catch (JSONException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}