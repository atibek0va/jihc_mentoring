package com.example.mentoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MentorMentee extends AppCompatActivity implements View.OnClickListener{

    private Button btnMentee;
    private Button btnMentor;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_mentee);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        btnMentee = findViewById(R.id.btnMentee);
        btnMentor = findViewById(R.id.btnMentor);
        btnNext = findViewById(R.id.btnNext);

        btnMentee.setOnClickListener(this);
        btnMentor.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnMentee){
            Intent regis_page = new Intent(this, RegistrationMentee.class);
            startActivity(regis_page);
        }
        else if (v.getId() == R.id.btnMentor){
            Intent regiss_page = new Intent(this, RegistrationMentor.class);
            startActivity(regiss_page);
        }
    }
}