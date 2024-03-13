package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class admin extends AppCompatActivity {
    private TextView txt1;
    private Button bt1;
    private EditText edittxt1, edittxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        txt1 = (TextView) findViewById(R.id.textViewid);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin.this, loginpage.class));
            }
        });
        bt1 = (Button) findViewById(R.id.buttonid);
        edittxt1 = (EditText) findViewById(R.id.LoginUsernameid);
        edittxt2 = (EditText) findViewById(R.id.LoginPasswordid);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = "00000000";
                String y = "Admin";
                String name = edittxt1.getText().toString();
                String password = edittxt2.getText().toString();
                if (name.length() == 0 || password.length() == 0) {
                    Toast.makeText(admin.this, "Information Missing", Toast.LENGTH_SHORT).show();
                } else {
                    if (name.compareTo(y) == 0 && password.compareTo(x) == 0) {
                        Toast.makeText(admin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(admin.this, adoption.class));
                    } else {
                        Toast.makeText(admin.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}