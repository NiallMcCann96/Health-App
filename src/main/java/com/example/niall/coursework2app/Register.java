package com.example.niall.coursework2app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        {
        Button back =(Button)findViewById(R.id.BBack);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent int6 = new Intent(Register.this, MainActivity.class);
                startActivity(int6);
            }});


        Button signUp=(Button)findViewById(R.id.BSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            EditText age = (EditText) findViewById(R.id.TFAge);
            EditText email = (EditText) findViewById(R.id.TFEmail);
            EditText username = (EditText) findViewById(R.id.TFUsername);
            EditText password = (EditText) findViewById(R.id.TFPassword);
            EditText confirmPassword = (EditText) findViewById(R.id.TFConfirmPassword);


            String ageString = age.getText().toString();
            String emailString = email.getText().toString();
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            String confirmPasswordString = confirmPassword.getText().toString();

            if (!passwordString.equals(confirmPasswordString))

            {
                Toast pass = Toast.makeText(Register.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else {
                //insert details into database
                UserDetails d = new UserDetails();
                d.setName(usernameString);
                d.setEmail(emailString);
                d.setAge(ageString);
                d.setPassword(passwordString);

                helper.insertUserDetails(d);



                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);


            }
        }
        });}}}







