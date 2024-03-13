package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class homepage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
        String username = sf.getString("username", "");
        CardView foodCard = findViewById(R.id.foodId);
        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, food.class));
            }
        });

        CardView hoTel = (CardView) findViewById(R.id.hotelId);
        hoTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, room.class));
            }
        });
        CardView plane = (CardView) findViewById(R.id.PlaneId);
        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, flight.class));
            }
        });
        CardView Admin = (CardView) findViewById(R.id.admin);
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, admin.class));
            }
        });
        CardView user = (CardView) findViewById(R.id.accountid);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, account.class));
            }
        });
        CardView k = (CardView) findViewById(R.id.tourid1);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homepage.this, touractivity.class));
            }
        });


    }
}
