package com.cookandroid.soloproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class page1 extends AppCompatActivity {

    Button backbuttom1;

    TextView countdownText;

    Button startButton, stopButton,
    cancelButton;

    EditText hourText, minText, secondText;

    CountDownTimer countDownTimer;

    boolean timerRunning, firstState;
    long time = 0, tempTime = 0;
    FrameLayout setting, timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        countdownText = (TextView) findViewById(R.id.countdown_text);

        startButton = (Button) findViewById(R.id.conutdown_button);
        stopButton = (Button) findViewById(R.id.stop_btn);
        cancelButton = (Button) findViewById(R.id.cancel_btn);

        hourText = (EditText) findViewById(R.id.hour);
        minText = (EditText) findViewById(R.id.min);
        secondText = (EditText) findViewById(R.id.second);

        setting =  (FrameLayout) findViewById(R.id.setting);
        timer =  (FrameLayout) findViewById(R.id.timer);

        backbuttom1 = (Button) findViewById(R.id.backbuttom1);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstState = true;

                setting.setVisibility(setting.GONE);
                timer.setVisibility(timer.VISIBLE);
                startStop();
            }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting.setVisibility(setting.VISIBLE);
                timer.setVisibility(timer.GONE);
                firstState = true;
                stopTimer();
            }
        });


        backbuttom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        updateTimer();
    }

    private void startTimer(){

        if (firstState){
            String sHour = hourText.getText().toString();
            String sMin = minText.getText().toString();
            String sSecond = secondText.getText().toString();
        }

    }










    }
