package com.example.krzysiek.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Krzysiek on 18.01.2018.
 */

public class StartActivity extends AppCompatActivity {

    private ListView list ;
    private ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        list = (ListView) findViewById(R.id.listView);

        final String cities[] = {"Lodz",
                            "Warsaw",
                            "Krakow",
                            "Gdansk",
                            "Szczecin",
                            "Katowice",
                            "Wroclaw",
                            "Poznan",
                            "Bydgoszcz",
                            "Lublin",
                            "Zielona Gora",
                            "Sieradz",
                            "Zdunska Wola"};

        ArrayList<String> cityList = new ArrayList<String>();
        cityList.addAll(Arrays.asList(cities));

        adapter = new ArrayAdapter<String>(this, R.layout.row, cityList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String city = cities[i];
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("CITY", city);
                startActivity(intent);
            }
        });

    }
}