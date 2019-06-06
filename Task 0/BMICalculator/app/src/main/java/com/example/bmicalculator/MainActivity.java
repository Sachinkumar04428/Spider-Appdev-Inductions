package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textWeight;
    TextView textHeight;
    TextView textBmi;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textWeight = findViewById(R.id.textWeight);
        textHeight = findViewById(R.id.textHeight);
        textBmi    = findViewById(R.id.textBmi);
    }


    public void showBmi(View view)
    {
        float weight = Float.parseFloat(textWeight.getText().toString());
        float height = Float.parseFloat(textHeight.getText().toString());

        float bmi = weight/(height*height);
        double bmiRoundoff =  Math.round(bmi*100.0)/100.0;

        String category = getCategory(bmiRoundoff);


        String bmi_string = "BMI: "+bmiRoundoff+"\n"+category;
        textBmi.setText(bmi_string);

    }

    public String getCategory(Double bmi)
    {
        if(bmi<=18.5)
            return getResources().getString(R.string.underweight);
        else if(bmi>18.5 && bmi<25.0 )
            return getResources().getString(R.string.normal);
        else if(bmi>=25.0 && bmi<30.0)
            return getResources().getString(R.string.overweight);
        else
            return getResources().getString(R.string.obese);

    }
}
