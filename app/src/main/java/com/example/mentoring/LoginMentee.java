package com.example.mentoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mentoring.StoreDatabase;

import static com.example.mentoring.StoreDatabase.COLUMN_USER_EMAIL;
import static com.example.mentoring.StoreDatabase.COLUMN_USER_PASSWORD;
import static com.example.mentoring.StoreDatabase.TABLE_USERS;

public class LoginMentee extends AppCompatActivity implements View.OnClickListener{

    private StoreDatabase storeDatabase;
    private SQLiteDatabase sqbd;

    EditText editMail;
    EditText editPassword;
    Button btnKiru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mentee);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        storeDatabase = new StoreDatabase(this);
        sqbd = storeDatabase.getWritableDatabase();

        editMail = findViewById(R.id.editMail);
        editPassword = findViewById(R.id.editPassword);
        btnKiru = findViewById(R.id.btnKiru);
        btnKiru.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(editMail.getText())){
            editMail.setError("Email bos(");
        }
        if(TextUtils.isEmpty(editPassword.getText())){
            editPassword.setError("Qupia soz bos(");
        }

        Cursor userCursor = sqbd.rawQuery(" SELECT * FROM " + TABLE_USERS +
                        " WHERE " + COLUMN_USER_EMAIL + " =? AND " + COLUMN_USER_PASSWORD + " =? ",
                new String[]{editMail.getText().toString(), editPassword.getText().toString()});

        if (((userCursor != null) && (userCursor.getCount() > 0))){
            userCursor.moveToFirst();
            String userEmail = userCursor.getString(userCursor.getColumnIndex(COLUMN_USER_EMAIL));
            Toast.makeText(this, "Qosh keldiniz, " + userEmail + "!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Invalid User!", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "Siz tirkeldińiz!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }
}