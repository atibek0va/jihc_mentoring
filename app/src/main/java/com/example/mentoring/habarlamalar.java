package com.example.mentoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class habarlamalar extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btnNews;
    private ImageButton btnMap;
    private ImageButton btnUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habarlamalar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        btnNews = findViewById(R.id.btnNews);
        btnMap = findViewById(R.id.btnMap);
        btnUser = findViewById(R.id.btnUser);


        btnNews.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnNews){
            Intent news_page = new Intent(this,basty_bet.class);
            startActivity(news_page);
        }
        else if (v.getId() == R.id.btnMap){
            Intent map_page = new Intent(this,habarlamalar.class);
            startActivity(map_page);
        }

        else {
            Intent user_page = new Intent(this,MainActivity.class);
            startActivity(user_page);
        }
    }
}