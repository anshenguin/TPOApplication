package com.example.tpoapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class HomeScreenActivity extends AppCompatActivity {
    int SELECTED_OPTION;
    RelativeLayout companies;
    RelativeLayout reg;
    Button locate;
    RelativeLayout about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        companies = findViewById(R.id.companies);
        reg = findViewById(R.id.register);
        locate = findViewById(R.id.locate);
        about = findViewById(R.id.about);
//        about_d = findViewById(R.id.about_d);

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://goo.gl/maps/YmizxbLXVRN2";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        companies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SELECTED_OPTION = 1;
                sendIntent();
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://davietjal.org/ggn/registration.php";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SELECTED_OPTION = 3;
                sendIntent();
            }
        });
//
//        about_d.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String url = "http://davietjal.org/about";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
    }

    public void sendIntent(){
        Intent intent = new Intent(HomeScreenActivity.this,MainActivity.class);
        intent.putExtra("Option",SELECTED_OPTION);
        startActivity(intent);
    }
}
