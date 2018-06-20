package com.example.niall.coursework2app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView)findViewById(R.id.TVUsername);
        tv.setText(username);


        Button bmi = (Button) findViewById(R.id.BBMI);
    bmi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Login.this,BMICalculator.class);
            startActivity(i);
        }
    });

        Button workout = (Button) findViewById(R.id.BWorkout);
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,YoutubeVideo.class);
                startActivity(i);
            }
        });
        Button logout = (Button) findViewById(R.id.BLogOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,MainActivity.class);
                startActivity(i);
            }
        });

        Button tips = (Button) findViewById(R.id.BTips);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,TipsSlideshow.class);
                startActivity(i);
            }
        });
}}
