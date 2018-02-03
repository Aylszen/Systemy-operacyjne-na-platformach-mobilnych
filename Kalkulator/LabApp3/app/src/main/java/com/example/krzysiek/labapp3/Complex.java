package com.example.krzysiek.labapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Complex extends AppCompatActivity {
    private TextView textView;
    private String resultText = "0";
    private double result = 0;
    private String current = "";
    private boolean firstUse = true;
    private boolean doubleClick = false;
    private boolean percentage = false;
    private boolean firstUseCalculation = true;
    private double temporary = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        textView = findViewById(R.id.txtScreen);
        textView.setText(resultText);
    }

    public void numberClick(String number) {
        if(resultText!="0") {
            resultText += number;
        }
        else if(resultText == "0" || percentage == true)
        {
            resultText = number;
        }
        textView.setText(resultText);
        doubleClick = false;
        firstUseCalculation = true;
    }
    public void clickOne(View view){
        numberClick("1");
    }

    public void clickTwo(View view){
        numberClick("2");
    }

    public void clickThree(View view){
        numberClick("3");
    }

    public void clickFour(View view){
        numberClick("4");
    }

    public void clickFive(View view){
        numberClick("5");
    }

    public void clickSix(View view){
        numberClick("6");
    }

    public void clickSeven(View view){
        numberClick("7");
    }

    public void clickEight(View view){
        numberClick("8");
    }

    public void clickNine(View view){
        numberClick("9");
    }

    public void clickZero(View view){
        numberClick("0");
    }
    public void clickPositive(View view){
        calculate();
        current = "+";

    }

    public void calculate()
    {
        if(doubleClick==false) {
            if (firstUse == false) {
                CharSequence cs = textView.getText();
                temporary = Double.parseDouble(cs.toString());
                resultion();
            }
            else {
                result = Double.parseDouble(resultText);
            }
            resultText = Double.toString(result);
            textView.setText(resultText);
            resultText = "";
            firstUse = false;
            doubleClick = true;
            firstUseCalculation = true;
        }
    }

    public void clickNegative(View view){
        calculate();
        current = "-";

    }

    public void clickMultiply(View view){
        calculate();
        current = "*";

    }

    public void clickDivide(View view){
        calculate();
        current = "/";

    }

    public void clickPowerY(View view){
        current = "^Y";
        calculate();
    }

    public void clickPowerTwo(View view){
        current = "^2";
        firstUse = false;
        calculate();
        doubleClick =false;
    }

    public void clickLogXY(View view){
        current = "logxy";
        calculate();
    }

    public void clickLn(View view){
        current = "ln";
        firstUse = false;
        calculate();
        doubleClick =false;
    }

    public void clickRoot(View view){
        current = "root";
        firstUse = false;
        calculate();
        doubleClick =false;

    }

    public void clickPoint(View view){
        if(Double.parseDouble(resultText)%1==0) {
            resultText += ".";
            textView.setText(resultText);
        }

    }

    public void clickPercent(View view){
        resultText = Double.toString(result*(Double.parseDouble(resultText)/100));
        textView.setText(resultText);
        percentage = true;

    }

    public void clickChange(View view){
        if(firstUse) {
            result = Double.parseDouble(resultText);
            result = -result;
            resultText = Double.toString(result);
        }
        else
        {
            resultText = "-"+resultText;
        }
        textView.setText(resultText);
    }

    public void clickC(View view){
        result = 0;
        resultText = "0";
        textView.setText(resultText);
        firstUse = true;
        doubleClick = false;
    }
    public void resultion()
    {
        switch(current)
        {
            case "+":
                result += temporary;
                break;
            case "-":
                result -= temporary;
                break;
            case "*":
                result *= temporary;
                break;
            case "/":
                result /= temporary;
                break;
            case "^Y":
                result = Math.pow(result,temporary);
                break;
            case "^2":
                result = Math.pow(temporary,2);
                break;
            case "ln":
                result = Math.log(temporary);
                break;
            case "logxy":
                result = Math.log(result)/Math.log(temporary);
                break;
            case "root":
                result = Math.sqrt(temporary);
            default:
                break;
        }
    }
    public void clickResult(View view){
        if(firstUseCalculation) {
            temporary = Double.parseDouble(resultText);
        }
        resultion();
        firstUse = true;
        doubleClick = false;
        resultText = Double.toString(result);
        textView.setText(Double.toString(result));
        firstUseCalculation = false;
    }


}
