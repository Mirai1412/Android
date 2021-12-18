package com.cookandroid.soloproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;
    Button bt1;
    Button bt2, bt3, bt4, bt5;
    EditText user1, user2;
    TextView toastText1;
    View ToastView, userView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);

//        DateFormat formatter5 = DateFormat.getDateInstance(DateFormat.FULL);
//        formatter5.setTimeZone(cal.getTimeZone());
//        String tot_str = formatted1 + "\n" + formatted2 + "\n" + formatted3 + "\n" + formatted4 + "\n" + formatted5;
//        Toast.makeText(this, tot_str, Toast.LENGTH_LONG).show();


        Refresh();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userView = (View) View.inflate(MainActivity.this, R.layout.user, null);

                AlertDialog.Builder user = new AlertDialog.Builder(MainActivity.this);
                user.setTitle("사용자 정보 입력");
                user.setView(userView);
                user.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                user1 = (EditText) userView.findViewById(R.id.user1);
                                user2 = (EditText) userView.findViewById(R.id.user2);

                                tvName.setText(user1.getText().toString());
                                tvEmail.setText(user2.getText().toString());
                            }
                        });

                user.setNegativeButton("취소",
                    new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        ToastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText1 = (TextView) ToastView.findViewById(R.id.toastText1);
                        toastText1.setText("취소했습니다.");
                        toast.setView(ToastView);
                        toast.show();

                    }
                });
                user.show();

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),page1.class);
                startActivity(intent);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),page1.class);
                startActivity(intent);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),page1.class);
                startActivity(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),page1.class);
                startActivity(intent);
            }
        });

    }

    void Refresh(){
        StringBuilder time = new StringBuilder();

        long epoch = System.currentTimeMillis();
        Calendar cal = new GregorianCalendar();
        time.append(String.format("%d년 %d월 %d일 %d시 %d분\n",

                cal.get(Calendar.YEAR),

                cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH),

                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE)));

        Date now = new Date();
        //SimpleDateFormat 클래스를 사용해서 표시하는 포맷을 바꿔준다.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        Calendar tom = new GregorianCalendar();
        tom.add(Calendar.DAY_OF_MONTH, 1);//내일날짜를 위해 1일을 더한다.

        Date tomdate = tom.getTime();
        //포맷을 바꿔주고
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
        TextView result = (TextView)findViewById(R.id.result);
        result.setText(time.toString());

    }





}