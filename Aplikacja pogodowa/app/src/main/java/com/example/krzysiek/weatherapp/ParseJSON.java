package com.example.krzysiek.weatherapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

class ParseJSON {

    public static Weather parse(Context context, JSONObject data) throws JSONException, ExecutionException, InterruptedException {
        Weather weather = new Weather();
        JSONObject mainObj = data.getJSONObject("main");
        weather.temp = String.valueOf(mainObj.getDouble("temp"));
        weather.pressure = String.valueOf(mainObj.getInt("pressure"));
        weather.humidity = String.valueOf(mainObj.getInt("humidity"));

        weather.cityName = data.getString("name");

        JSONArray jArr = data.getJSONArray("weather");
        JSONObject JSONWeather = jArr.getJSONObject(0);

        weather.icon = JSONWeather.getString("icon");
        weather.description = JSONWeather.getString("description").toUpperCase();
        weather.iconData = new RemoteFetchIcon(context).execute(weather.icon).get();

        return weather;
    }

}
