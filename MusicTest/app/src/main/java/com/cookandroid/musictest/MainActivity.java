package com.cookandroid.musictest;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button btnStart, btnStop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("서비스 테스트 예제");

        //★ 입력하기. MusicService.class 파일을 인텐트로 생성함
        intent = new Intent(this, MusicService.class);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);


        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //★ 입력하기. <음악서비스 시작> 버튼 클릭시 startService()
                startService(intent);
                android.util.Log.i("서비스 테스트", "startService()");
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //★입력하기. <음악서비스 중지> 버튼 클릭시 stopService()

                android.util.Log.i("서비스 테스트", "stopService()");
            }
        });
    }
}