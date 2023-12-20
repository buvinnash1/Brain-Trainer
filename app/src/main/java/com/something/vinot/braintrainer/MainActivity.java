package com.something.vinot.braintrainer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    TextView result;
    TextView points;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button exitbutton;
    ImageView mutebutton;
    TextView timer;
    TextView question = null;
    Button playagain;
    boolean mute = true;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberofquestions = 0;


    public void playagainclick(final View view) {

        score = 0;
        numberofquestions = 0;


        timer.setText("30s");
        points.setText("0/0");
        result.setText("");
        playagain.setVisibility(View.INVISIBLE);
        generatequestion();
        final MediaPlayer waterprooftapebeats = MediaPlayer.create(this, R.raw.beats);
        waterprooftapebeats.start();

        mutebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mute == true) {
                    waterprooftapebeats.setVolume(0, 0);
                    mutebutton.setImageResource(R.drawable.mutebutton);
                    mute = false;
                }
                else {
                    waterprooftapebeats.setVolume(1,1);
                    mutebutton.setImageResource(R.drawable.unmutebutton);
                    mute = true;
                    }
            }
        });
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, splashscreen.class));
                waterprooftapebeats.stop();
            }


        });





        new CountDownTimer(30300, 1000) {
            @Override
            public void onTick(long millisUnitFinished) {

                timer.setText(String.valueOf(millisUnitFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playagain.setVisibility(View.VISIBLE);
                playagain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playagainclick(findViewById(R.id.playagain));
                        generatequestion();
                    }

                });
                timer.setText("0s");
                if (score == 30) {
                    result.setText("Your score:" + Integer.toString(score) + "/" + Integer.toString(numberofquestions) + "Your score is average");
                }
                if (score < 30) {
                    result.setText("Your score:" + Integer.toString(score) + "/" + Integer.toString(numberofquestions) + "Your score is below average");
                }
                if (score > 30) {
                    result.setText("Your score:" + Integer.toString(score) + "/" + Integer.toString(numberofquestions) + "Your score is above average");
                }
                waterprooftapebeats.stop();


            }
        }.start();
    }



    public void generatequestion() {
        if (timer.getText().equals("0s")){
            return;
        }


        Random rand = new Random();

        int num1 = rand.nextInt(21);
        int num2 = rand.nextInt(21);

        question.setText(Integer.toString(num1) + "+" + Integer.toString(num2));


        locationOfCorrectAnswer = rand.nextInt(4);



        answers.clear();

        int incorrectAnswer;

        for (int i = 0; i < 4; i++) {

            if (timer.getText().equals("0s")){
                return;
            }
            if (i == locationOfCorrectAnswer) {

                answers.add(num1 + num2);
            } else {

                incorrectAnswer = rand.nextInt(41);


                while (incorrectAnswer == num1 + num2) {

                    incorrectAnswer = rand.nextInt(41);

                }









                answers.add(incorrectAnswer);



            }


        }


        button1.setText(Integer.toString(answers.get(0)));

        if (button1.getText().equals(answers.get(1))){
            int newrand = rand.nextInt(41);
            button1.setText(newrand);
        }
        if (button1.getText().equals(answers.get(2))){
            int newrand = rand.nextInt(41);
            button1.setText(newrand);
        }
        if (button1.getText().equals(answers.get(3))){
            int newrand = rand.nextInt(41);
            button1.setText(newrand);
        }
        button2.setText(Integer.toString(answers.get(1)));

        if (button2.getText().equals(answers.get(0))){
            int newrand = rand.nextInt(41);
            button2.setText(newrand);
        }
        if (button2.getText().equals(answers.get(2))){
            int newrand = rand.nextInt(41);
            button2.setText(newrand);
        }
        if (button2.getText().equals(answers.get(3))){
            int newrand = rand.nextInt(41);
            button2.setText(newrand);
        }
        button3.setText(Integer.toString(answers.get(2)));

        if (button3.getText().equals(answers.get(0))){
            int newrand = rand.nextInt(41);
            button3.setText(newrand);
        }
        if (button3.getText().equals(answers.get(1))){
            int newrand = rand.nextInt(41);
            button3.setText(newrand);
        }
        if (button3.getText().equals(answers.get(3))){
            int newrand = rand.nextInt(41);
            button3.setText(newrand);
        }
        button4.setText(Integer.toString(answers.get(3)));

        if (button4.getText().equals(answers.get(0))){
            int newrand = rand.nextInt(41);
            button4.setText(newrand);
        }
        if (button4.getText().equals(answers.get(1))){
            int newrand = rand.nextInt(41);
            button4.setText(newrand);
        }
        if (button4.getText().equals(answers.get(2))){
            int newrand = rand.nextInt(41);
            button4.setText(newrand);
        }



        if (timer.getText().equals("0s")){
            return;
        }



    }



    public void chooseAnswer(View view) {

        if (timer.getText().equals("0s")){
            return;
        }

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            result.setText("correct!");
        }
        else {
            result.setText("wrong!");
        }

        numberofquestions++;
        points.setText(Integer.toString(score)+"/"+Integer.toString(numberofquestions));

        generatequestion();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timer = (TextView) findViewById(R.id.timer);
        question = (TextView) findViewById(R.id.question);
        points = (TextView) findViewById(R.id.points);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        result = (TextView) findViewById(R.id.result);
        playagain = (Button) findViewById(R.id.playagain);
        exitbutton = (Button) findViewById(R.id.exitbutton);
        mutebutton = (ImageView) findViewById(R.id.mutebutton);


        playagainclick(findViewById(R.id.playagain));






    }


}
