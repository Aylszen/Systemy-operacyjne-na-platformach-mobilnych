package com.example.ekrzkit.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class Config{
    static final int RESULT_CODE = 100;
}

public class MainActivity extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.veryImportantText);
        textView.setText(getString(R.string.veryImportantSentence));
        name = findViewById(R.id.name);
        Button button = findViewById(R.id.lowerButton);
        button.setText(getString(R.string.lowerButton));
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,NewActivity.class);
            startActivityForResult(intent,Config.RESULT_CODE);
        }
    });
    }

   public void OnButtonClick(@SuppressWarnings("unused") View view){
       Intent intent = new Intent(MainActivity.this,NewActivity.class);
       startActivityForResult(intent,Config.RESULT_CODE);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Config.RESULT_CODE){
            name.setText((CharSequence) data.getExtras().get(getString(R.string.keyName)));
        }
    }
}
