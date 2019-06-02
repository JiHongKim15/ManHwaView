
package com.example.jihong.anew;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public String[] manhwa = {"romance","sports","fantasy","daily","etc","comic","fight", "sf"};
    public static Activity ma;
    public static Context CONTEXT;
    public int romance = 0;
    public int sports = 0;
    public int SF = 0;
    public int fantasy = 0;
    public int daily = 0;
    public int etc = 0;
    public int comedy = 0;
    public int fight = 0;

    public int max = fantasy;
    public String recommends = "fantasy";

    public String title;
    //  public ImageView image = (ImageView)findViewById(R.id.romance1);


    @Override
    public void onResume(){
        super.onResume();

        String packName = this.getPackageName();
        recommendCompare(); //빈도 확인
        for(int i=0; i<2; i++) {

            String resName = "@drawable/" + recommends + i;
            int resID = getResources().getIdentifier(resName, "drawable", packName);

            String img = "imageView" + i;
            int byId = getResources().getIdentifier(img, "id", packName);

            ImageView iv = findViewById(byId);
            iv.setImageResource(resID);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //     ma = MainActivity.this;
        CONTEXT = this;

        //Button OpenButton = findViewById(R.id.button2);
        String packName = this.getPackageName();

        recommendCompare();
        for (int i = 0; i < 2; i++) {

            String resName = "@drawable/" + recommends + i;
            int resID = getResources().getIdentifier(resName, "drawable", packName);

            String img = "imageView" + i;
            int byId = getResources().getIdentifier(img, "id", packName);

            ImageView iv = findViewById(byId);
            iv.setImageResource(resID);
        }

        /*OpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //동작 내용 코딩
                //  Intent intent = new Intent(getApplicationContext(), Open.class);

                //새로운 view
                // startActivity(intent);
            }
        });*/

        //장르 검색
        Button RomanceButton = findViewById(R.id.button6);

        RomanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);

                intent.putExtra("key", "romance");

                startActivity(intent);
                romance++;
            }
        });

        Button SportsButton = findViewById(R.id.button9);

        SportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);

                intent.putExtra("key", "sports");


                startActivity(intent);
                sports++;
            }
        });
        Button SFButton = findViewById(R.id.button10);

        SFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);
                intent.putExtra("key", "sf");

                startActivity(intent);
                SF++;
            }
        });
        Button fantasyButton = findViewById(R.id.button7);

        fantasyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);
                intent.putExtra("key", "fantasy");

                startActivity(intent);
                fantasy++;
            }
        });
        Button fightButton = findViewById(R.id.button8);

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);
                intent.putExtra("key", "fight");

                startActivity(intent);
                fight++;
            }
        });
        Button dailyButton = findViewById(R.id.button11);

        dailyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);
                intent.putExtra("key", "daily");

                startActivity(intent);
                daily++;
            }
        });
        Button etcButton = findViewById(R.id.button13);

        etcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);
                intent.putExtra("key", "etc");

                startActivity(intent);
                etc++;
            }
        });
        Button comedyButton = findViewById(R.id.button12);

        comedyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), romance.class);
                intent.putExtra("key", "comic");

                startActivity(intent);
                comedy++;
            }
        });



        Button searchButton = findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTitle = (EditText) findViewById(R.id.editTitle);

                title = editTitle.getText().toString();
                if (title.length() == 0) {
                    //팝업
                    Toast.makeText(MainActivity.this, "제목을 입력해 주세요.", Toast.LENGTH_LONG).show();
                } else {
                    // int resID = getResources().getIdentifier(title, "drawable", "com.example.jihong.anew");

                    int signal = 0;
                    for (int i = 0; i < manhwa.length; i++) {
                        if (title.contains(manhwa[i])) {
                            signal = 1;
                            if (title.contains("romance")) romance++;
                            else if (title.contains("fight")) fight++;
                            else if (title.contains("comic"))  comedy++;
                            else if (title.contains("sf")) SF++;
                            else if (title.contains("etc")) etc++;
                            else if (title.contains("daily")) daily++;
                            else if (title.contains("fantasy")) fantasy++;
                            else if (title.contains("sports")) sports++;

                            Toast.makeText(MainActivity.this, "검색 완료", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), openview.class);

                            intent.putExtra("openV", title);

                            startActivity(intent);
                            break;
                        }
                    }
                    if(signal == 0){
                        Toast.makeText(MainActivity.this, "검색 결과가 없습니다.", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    public void recommendCompare(){

        if(max < fantasy){
            max = fantasy;
            recommends = "fantasy";
        }

        if(sports> max) {
            max = sports;
            recommends = "sports";
        }
        if(SF>max){
            max = SF;
            recommends = "sf";
        }
        if(max < romance){
            max = fantasy;
            recommends = "romance";
        }
        if(max < etc){
            max = etc;
            recommends = "etc";
        }
        if(max < daily){
            max = daily;
            recommends = "daily";
        }
        if(max < comedy){
            max = comedy;
            recommends = "comic";
        }
        if(max < fight){
            max = fight;
            recommends = "fight";
        }
    }
}
