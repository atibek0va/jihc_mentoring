package com.example.mentoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class saualnama4 extends AppCompatActivity implements View.OnClickListener{
    Button btnOtuu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saualnama4);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        btnOtuu = findViewById(R.id.btnOtuu);
        btnOtuu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent ottu = new Intent(this, basty_bet.class);
        startActivity(ottu);
    }
}