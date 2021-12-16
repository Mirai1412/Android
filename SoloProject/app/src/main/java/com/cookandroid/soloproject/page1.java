package com.cookandroid.soloproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class page1 extends AppCompatActivity {

    Button backbuttom1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        backbuttom1 = (Button) findViewById(R.id.backbuttom1);

        backbuttom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }
    }