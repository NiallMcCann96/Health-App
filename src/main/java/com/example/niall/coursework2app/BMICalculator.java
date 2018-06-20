package com.example.niall.coursework2app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmicalculator);

        Button mainMenu;
        mainMenu = (Button) findViewById(R.id.BMainMenu2);


        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent i = new Intent(BMICalculator.this, Login.class);
                startActivity(i);}
        });


        final EditText etKG = (EditText) findViewById(R.id.ETKG);
        final EditText etCM = (EditText) findViewById(R.id.ETCM);
        final TextView tvCalc = (TextView) findViewById(R.id.TVCalc);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String kg = etKG.getText().toString();
                String cm = etCM.getText().toString();

                if(TextUtils.isEmpty(kg)){
                    etKG.setError("Please enter your weight");
                    etKG.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(cm)){
                    etCM.setError("Please enter your height");
                    etCM.requestFocus();
                    return;
                }


                float weight = Float.parseFloat(kg);
                float height = Float.parseFloat(cm)/100;


                float bmiValue = calculateBMI(weight, height);


                String bmi = BMI(bmiValue);

                tvCalc.setText(String.valueOf(bmiValue + "-" + bmi));

            }
        });

    }

    private float calculateBMI (float weight, float height) {
        return  (weight / (height * height));
    }

    private String BMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Very underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Very overweight";
        }
}
}
