package com.example.krzysiek.weatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private TextView cityText;
    private TextView temperature;
    private TextView description;
    private TextView humidity;
    private TextView pressure;

    private ImageView icon;
    JSONObject data;
    Weather weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String city = this.getIntent().getStringExtra("CITY");
        cityText = findViewById(R.id.city_field);
        temperature  = findViewById(R.id.current_temperature_field);
        icon = findViewById(R.id.icon);
        description = findViewById(R.id.description);
        pressure = findViewById(R.id.pressure);
        humidity = findViewById(R.id.humidity);

        data = new RemoteFetchWeather(getApplicationContext()).execute(city).get();
        weather = ParseJSON.parse(getApplicationContext(), data);

        temperature.setText (Double.toString(weather.temp) + " ℃");
        cityText.setText(weather.cityName);
        Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
        icon.setImageBitmap(img);
        description.setText(weather.description);
        pressure.setText(getApplicationContext().getString(R.string.pressure) + " " + weather.pressure + " hPa");
        humidity.setText(getApplicationContext().getString(R.string.humidity) + " " + weather.humidity + "%");

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}