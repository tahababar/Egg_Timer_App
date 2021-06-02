package com.example.tahababar.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar timerSeekBar = findViewById(R.id.seekBar);
    final TextView textView = findViewById(R.id.textViewTimer);



    public void buttonClicked(View view){
        timerSeekBar.setEnabled(false);  //will block user from changing seekbar
        Button button = findViewById(R.id.goButton);
        button.setText("EGGS GETTING READY!");


        CountDownTimer countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int time = (int) millisUntilFinished/1000; //all these 1000s are here because we are dealing with milliseconds
                int minutes = time/60;
                int seconds = time - (minutes * 60);
                String secondString = Integer.toString(seconds);
                if (seconds == 0){
                    secondString.equals("00");
                }
                textView.setText(minutes + ":" + secondString);
            }

            @Override
            public void onFinish() {
                Log.i("Finished", "Timer done!");

                //can add a media player here too if you want an alarm
            }
        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar.setMax(600); //i.e. 10 minutes
        timerSeekBar.setProgress(30); //starting position at 30s

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = progress/60;
                int seconds = progress - (minutes * 60);
                String secondString = Integer.toString(seconds);
                if (seconds == 0){
                    secondString.equals("00");
                }
                textView.setText(minutes + ":" + secondString);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}





/*

to put somethiing on top of a image, click on that and then choose center->center horizontaly
 */