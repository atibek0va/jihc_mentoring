package com.example.mentoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class saualnama3 extends AppCompatActivity implements View.OnClickListener{
    Button btnOtu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saualnama3);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        btnOtu = findViewById(R.id.btnOtu);
        btnOtu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent otu = new Intent(this, basty_bet.class);
        startActivity(otu);
    }
}