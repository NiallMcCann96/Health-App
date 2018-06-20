package com.example.niall.coursework2app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnLogin;
        btnLogin = (Button) findViewById(R.id.BLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText a, b;
                a = (EditText) findViewById(R.id.TFUsername);
                b = (EditText) findViewById(R.id.TFPassword);

                String str = a.getText().toString();

                String pass = b.getText().toString();

                String password = helper.searchPass(str);
                if(password.equals(pass))
                {
                    Intent i = new Intent(MainActivity.this, Login.class);
                    i.putExtra("Username",str);
                    startActivity(i);
                }
                else
                {

                    Toast temp = Toast.makeText(MainActivity.this , "Username and Password Dont Match!" , Toast.LENGTH_SHORT);
                    temp.show();

                }

            }
        }
        );

        Button btnRegister;
        btnRegister = (Button) findViewById(R.id.BRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);

            }
        }
        );


    }}






