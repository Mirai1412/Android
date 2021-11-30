package com.cookandroid.bartest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pb1;
        Button btnInc, btnDec;

        pb1 = (ProgressBar) findViewById(R.id.progressBar1);
        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);


        // ★입력하기, btnInc 버튼(10씩 증가) 클릭시 리스너. 프로그레스바(pb1) 10씩 증가
        //  incrementProgressBy() 메서드 사용
        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.incrementProgressBy(10);
            }
        });

        // ★입력하기, btnDec 버튼(10씩 감소) 클릭시 리스너. 프로그레스바(pb1) -10씩 감소
        //  incrementProgressBy() 메서드 사용. 음수값을 입력하면 감소함.
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.incrementProgressBy(-10);
            }
        });


        final TextView tvSeek = (TextView) findViewById(R.id.tvSeek);
        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);

        // ★입력하기, SeekBar.OnSeekBarChangeListener()
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행률 : " + progress + "%");
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
