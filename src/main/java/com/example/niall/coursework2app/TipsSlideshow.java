package com.example.niall.coursework2app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class TipsSlideshow  extends Activity  implements View.OnClickListener {

    ViewFlipper viewFlipper;
    Button next;
    Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipsslideshow);

        Button mainMenu;
        mainMenu = (Button) findViewById(R.id.BMainMenu4);


        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent i = new Intent(TipsSlideshow.this, Login.class);
                startActivity(i);}
        });

        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.BNext);
        previous = (Button) findViewById(R.id.BPrevious);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == next) {
            viewFlipper.showNext();
        }
        else if (v == previous) {
            viewFlipper.showPrevious();
        }
    }
}

