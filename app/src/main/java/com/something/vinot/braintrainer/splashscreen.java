package com.something.vinot.braintrainer;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button additiontrainer = (Button)  findViewById(R.id.additionbutton);
        final Button subtractiontrainer = (Button)  findViewById(R.id.subtractionbutton);
        final Button multiplicationtrainer = (Button) findViewById(R.id.multiplicationbutton);
        final Button randomtrainer = (Button) findViewById(R.id.randomtrainer);

        randomtrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splashscreen.this, randomtrainer.class));
            }
        });



        multiplicationtrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splashscreen.this, multiplicationscreen.class));
            }
        });

        subtractiontrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splashscreen.this, subtractionscreen.class));
                                                  }

        });
        additiontrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splashscreen.this, MainActivity.class));
            }

        });

    }

}
