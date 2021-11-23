package com.cookandroid.gallery;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        //★ 입력하기, MyGalleryAdapter 변수를 생성하여 갤러리 gallery에 적용한다
        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);

    }

    // BaseAdapter를 상속 받아 MyGalleryAdapter를 정의한다
    public class MyGalleryAdapter extends BaseAdapter {

        Context context;

        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10 };

        public MyGalleryAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int arg0) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        //영화 포스터의 개수(10개)만큼 반복됨. 영화 포스터를 갤러리의 각 칸마다 보여주는 기능
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);
            //★ 입력하기, 갤러리에 영화 포스터 1개(파라미터로 넘어온 position 위치)를 적용한다.
            imageview.setImageResource(posterID[position]);

            //갤러리의 영화 포스터를 클릭하면 아래쪽 이미지뷰에 영화 포스터가 원래 크기로 보이게 한다
            final int pos = position;
            imageview.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
                    //★ 입력하기, 이미지뷰에 영화 포스터 1개(pos 위치)를 적용한다.
                    return false;
                }
            });

            return imageview;
        }
    }
}
