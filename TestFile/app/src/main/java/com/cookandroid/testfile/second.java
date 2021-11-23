package com.cookandroid.testfile;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        Intent inIntent = getIntent();
        String cal = (inIntent.getStringExtra("Cal"));
        int calValue = 0;

        if(cal.equals("+")) {
            calValue = inIntent.getIntExtra("Num1", 0) +
                    inIntent.getIntExtra("Num2", 0);
        }else if(cal.equals("-")){
            calValue = inIntent.getIntExtra("Num1", 0) -
                    inIntent.getIntExtra("Num2", 0);
        }else if(cal.equals("*")){
            calValue = inIntent.getIntExtra("Num1", 0) *
                    inIntent.getIntExtra("Num2", 0);
        }else{
            calValue = inIntent.getIntExtra("Num1", 0) /
                    inIntent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

        Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);

        outIntent.putExtra("result", retValue);
        setResult(RESULT_OK, outIntent);
        finish();
    }
}