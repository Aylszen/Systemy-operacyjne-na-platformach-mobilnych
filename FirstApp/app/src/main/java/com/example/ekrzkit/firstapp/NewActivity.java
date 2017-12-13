package com.example.ekrzkit.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity implements Button.OnClickListener {

    private EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newct);
        name = findViewById(R.id.name);
        TextView text = findViewById(R.id.giveYourNameText);
        text.setText(getString(R.string.giveYourName));
        Button b = new Button(this);
       //b.layout(R.id.parent, R.id.name, R.id.parent, R.id.parent);
       // b.layout();
        //b.setX(400);
        //b.setY(800);
        b.setText(getString(R.string.showNameButton));
        ConstraintLayout cl = findViewById(R.id.newLayout);
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //cl.
        cl.addView(b,lp);
        b.setOnClickListener(this);
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
