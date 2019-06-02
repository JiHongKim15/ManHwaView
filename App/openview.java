package com.example.jihong.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class openview extends AppCompatActivity {

    private View selected_item = null;
    ImageView img0, img1;
    ImageView imgOpen;
    private int w,h;
    int [] ImageID = {0, 0, 0, 0, 0};
    int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openview);

       // setTitle("MAIN");

        Intent intent = getIntent();
        String data = intent.getStringExtra("openV");
        String packName = this.getPackageName();


        setTitle(data);

        for (int i = 0; i < 5; i++) {

            String resName = "@drawable/" + data + i;
            int id = getResources().getIdentifier(resName, "drawable", packName);
            ImageID[i] = id;
        }

        imgOpen = findViewById(R.id.imgView);
        imgOpen.setImageResource(ImageID[page]);

        w = getWindowManager().getDefaultDisplay().getWidth() - 50;
        h = getWindowManager().getDefaultDisplay().getHeight() - 100;

        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);

        img0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                page--;
                if(page < 0) page ++;
                imgOpen.setImageResource(ImageID[page]);
            }
        });
        img1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                page++;
                if(page > 4) page--;
                imgOpen.setImageResource(ImageID[page]);
            }
        });

    }

}
