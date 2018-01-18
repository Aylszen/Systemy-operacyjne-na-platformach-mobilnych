package com.example.ekrzkit.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity implements Button.OnClickListener {

    private EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        name = findViewById(R.id.name);
        TextView text = findViewById(R.id.giveYourNameText);
        text.setText(getString(R.string.giveYourName));
        Button button = new Button(this);
        button.setText(getString(R.string.showNameButton));
        button.setWidth(50);
        button.setHeight(50);
        RelativeLayout relativeLayout = findViewById(R.id.newLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.setMargins(0,650,0,0);
        relativeLayout.addView(button,layoutParams);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(NewActivity.this,MainActivity.class);
        String text = String.valueOf(name.getText());
        intent.putExtra(getString(R.string.keyName),text);
        setResult(Config.RESULT_CODE,intent);
        finish();
    }
}
