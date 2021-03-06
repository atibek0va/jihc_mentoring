package com.example.mentoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class saualnama extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saualnama);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

        Spinner spinner = findViewById(R.id.spinner_group);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.groups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spin = findViewById(R.id.spinner_direction);
        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this, R.array.directions, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adap);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent nxt = new Intent(this, saualnama3.class);
        startActivity(nxt);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}