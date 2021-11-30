package com.cookandroid.dbtest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myDBHelper myHelper;   // myDBHelper 클래스 변수
    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqlDB;   //SQLiteDatabase클래스 변수

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 그룹 관리 DB");

        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        myHelper = new myDBHelper(this);    // myDBHelper 객체 생성. myDBHelper() 생성자실행되어 groupDB 파일 생성됨

        // <초기화> 클릭시 동작 리스너
        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //★ 입력하기. groupDB를 쓰기용 데이터베이스로 열고, onUpgrade 메서드 호출
            sqlDB = myHelper.getWritableDatabase();
            myHelper.onUpgrade(sqlDB, 1, 2);
            sqlDB.close();

            }
        });

        //<입력> 클릭시 동작 리스터
        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //★입력하기. groupDB를 쓰기용으로 연 후, insert 문을 생성하여 execSQL() 메서드 실행
                // execSQL() 메서드는 결과를 돌려받지 않는 쿼리 수행시

                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                    + edtName.getText().toString() + "',"
                    + edtNumber.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //<조회> 클릭시 동작 리스너
        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //★입력하기. groupDB를 읽기용으로 연후, cursor 객체를 선언하여 모든 테이블을 조회한 후 커서에 대입
                // cursor 변수에는 테이블에 입력된 모든 행 데이터가 들어 있는 상태. 현재 첫 번째 행을 가리키고 있

                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);




                String strNames = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String strNumbers = "인원" + "\r\n" + "--------" + "\r\n";

                //★입력하기.  while() 문으로 행 데이터 개수만큼 반복.
                // moveToNext() 메서드는 커서 변수의 다음 행으로 넘어가게 함
                //getString(열번호)

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0) + "\r\n";
                    strNumbers += cursor.getString(1) + "\r\n";
                }




                // 누적한 문자열을 에디트텍스트에 출력
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNumbers);

                //cursor와 데이터베이스를 닫는다.
                cursor.close();
                sqlDB.close();
            }
        });

    }


    // SQLiteOpenHelper 클래스 상속 받아 myDBHelper  클래스 정의
    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context){
            super((context, "groupDB", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20) PRIMARY KEY,gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
        }
//★ 입력하기. 생성자 정의. super()의 두번째 파라미터는 새로 생성될 데이터베이스 파일명
        // 마지막 파라미터는 데이터베이스 버전으로 처음에는 1을 지정



        //★ 입력하기. onCreate(), onUpgrade() 메서드
        // onCreate() 메서드는 테이블 생성. SQLiteDatabase 클래스의 execSQL() 메서드로 실행
        // onUpgreade() 메서드는 테이블을 삭제 후 다시 생성. 초기화할 때 호출


    }
}
