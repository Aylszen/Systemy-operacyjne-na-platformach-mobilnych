package com.example.krzysiek.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TextView pickCity = findViewById(R.id.pickCity);
        pickCity.setText(R.string.pick_a_city);
        ListView list = findViewById(R.id.listView);

        ArrayList<String> cityList = new ArrayList<>();
        cityList.addAll(Arrays.asList(getResources().getStringArray(R.array.cityArray)));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, cityList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String city[] = getResources().getStringArray(R.array.cityArray);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("CITY", city[i]);
                startActivity(intent);
            }
        });

    }
}