package com.example.mentoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import static com.example.mentoring.StoreDatabase.COLUMN_USER_EMAIL;
import static com.example.mentoring.StoreDatabase.COLUMN_USER_NAME;
import static com.example.mentoring.StoreDatabase.COLUMN_USER_PASSWORD;
import static com.example.mentoring.StoreDatabase.COLUMN_USER_PHONE;
import static com.example.mentoring.StoreDatabase.TABLE_USERS;


//
//import static com.example.project_with_database.database.StoreDatabase.COLUMN_USER_EMAIL;
//import static com.example.project_with_database.database.StoreDatabase.COLUMN_USER_NAME;
//import static com.example.project_with_database.database.StoreDatabase.COLUMN_USER_PASSWORD;
//import static com.example.project_with_database.database.StoreDatabase.COLUMN_USER_PHONE;
//import static com.example.project_with_database.database.StoreDatabase.TABLE_USERS;

public class RegistrationMentee extends AppCompatActivity implements View.OnClickListener{

    private StoreDatabase storeDatabase;
    private SQLiteDatabase sqbd;

    EditText editName;
    EditText editMail;
    EditText editPassword;
    EditText editPasswordAgain;
    Button btnTirkelu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_mentee);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        storeDatabase = new StoreDatabase(this);
        sqbd = storeDatabase.getWritableDatabase();

        editName = findViewById(R.id.editName);
        editMail = findViewById(R.id.editMail);
        editPassword= findViewById(R.id.editPassword);
        editPasswordAgain = findViewById(R.id.editPasswordAgain);
        btnTirkelu = findViewById(R.id.btnTirkelu);
        btnTirkelu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(editName.getText())){
            editName.setError("Fill again");
        }
        if(TextUtils.isEmpty(editMail.getText())){
            editMail.setError("Fill again");
        }
        if(TextUtils.isEmpty(editPassword.getText())){
            editPasswordAgain.setError("Fill again");
        }
        if(TextUtils.isEmpty(editPasswordAgain.getText())){
            editPasswordAgain.setError("Fill again");
        }

        ContentValues versionValues = new ContentValues();
        versionValues.put(COLUMN_USER_NAME, editName.getText().toString());
        versionValues.put(COLUMN_USER_EMAIL,editMail.getText().toString());
        versionValues.put(COLUMN_USER_PASSWORD,editPassword.getText().toString());
        versionValues.put(COLUMN_USER_PHONE,editPasswordAgain.getText().toString());

        sqbd.insert(TABLE_USERS, null, versionValues);
        Toast.makeText(this, "Inserted to Database", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginMentee.class);
        startActivity(intent);
    }
}