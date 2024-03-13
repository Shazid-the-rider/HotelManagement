package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class food extends AppCompatActivity {

    private CardView cardview1, cardview2, cardview3, cardview4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        cardview1 = (CardView) findViewById(R.id.card1);
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(food.this, desert.class));
            }
        });
        cardview2 = (CardView) findViewById(R.id.card2);
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(food.this, drinks1.class));
            }
        });
        cardview3 = (CardView) findViewById(R.id.card3);
        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(food.this, lunch.class));
            }
        });
        cardview4 = (CardView) findViewById(R.id.card4);
        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(food.this, homepage.class));
            }
        });
    }
}