package com.example.jihong.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.jihong.anew.R.id.imageView0;

public class romance extends AppCompatActivity {


    ImageView iv;
    String data;
    ImageView img0, img1, img2, img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romance);

        Intent intent = getIntent();
        data = intent.getStringExtra("key");
        String packName = this.getPackageName();

        setTitle(data);

        for (int i = 0; i < 4; i++) {
            String resName = "@drawable/" + data + i;
            String resText = data + i;
            int resID = getResources().getIdentifier(resName, "drawable", packName);

            String img = "imageView" + i;
            int byId = getResources().getIdentifier(img, "id", packName);

            String textv = "textView" + i;
            int tbyId = getResources().getIdentifier(textv, "id", packName);

            iv = findViewById(byId);
            iv.setImageResource(resID);

            TextView tv = findViewById(tbyId);
            tv.setText(resText);
        }

        img0 = findViewById(imageView0);
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);

        img0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String pass = data + "0";
                Intent intent = new Intent(getApplicationContext(), openview.class);

                intent.putExtra("openV",pass);

                startActivity(intent);
            }
        });
        img1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String pass = data + "1";
                Intent intent = new Intent(getApplicationContext(), openview.class);

                intent.putExtra("openV",pass);

                startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String pass = data + "2";
                Intent intent = new Intent(getApplicationContext(), openview.class);

                intent.putExtra("openV",pass);

                startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String pass = data + "3";
                Intent intent = new Intent(getApplicationContext(), openview.class);

                intent.putExtra("openV",pass);

                startActivity(intent);
            }
        });

        Button buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) MainActivity.CONTEXT).onResume();
                // MainActivity a = (MainActivity)MainActivity.ma;

                //a.recreate();

                onBackPressed();
            }
        });
    } //cerat 종료
}
