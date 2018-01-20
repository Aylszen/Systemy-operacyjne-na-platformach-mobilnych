package com.example.filip.labapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleClick(View view){
        Intent intent = new Intent(this,Simple.class);
        startActivity(intent);
    }

    public void complexClick(View view){
        Intent intent = new Intent(this,Complex.class);
        startActivity(intent);
    }

    public void closeAppClick(View view){
        finish();
    }
}
