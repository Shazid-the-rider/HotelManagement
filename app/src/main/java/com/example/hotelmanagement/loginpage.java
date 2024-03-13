package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginpage extends AppCompatActivity {
    private EditText userName, passWord;
    private Button logIn;
    private TextView textView, textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        userName = (EditText) findViewById(R.id.LoginUsernameid);
        passWord = (EditText) findViewById(R.id.LoginPasswordid);
        textView = (TextView) findViewById(R.id.textViewid);
        textView1 = (TextView) findViewById(R.id.textViewid1);
        logIn = (Button) findViewById(R.id.buttonid);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String password = passWord.getText().toString();
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                if (name.length() == 0 || password.length() == 0) {
                    Toast.makeText(loginpage.this, "Information Missing", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.signIn(name, password) == 1) {
                        Toast.makeText(loginpage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sf.edit();
                        editor.putString("username", name);
                        editor.apply();
                        startActivity(new Intent(loginpage.this, homepage.class));
                    } else {
                        Toast.makeText(loginpage.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginpage.this, signuppage.class));
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginpage.this, admin.class));
            }
        });


    }
}