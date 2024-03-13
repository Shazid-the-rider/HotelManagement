package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adoption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);
        CardView out = (CardView) findViewById(R.id.logout);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adoption.this, loginpage.class));
            }
        });
        CardView o = (CardView) findViewById(R.id.foodId);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adoption.this, adminfood.class));
            }
        });
        CardView p = (CardView) findViewById(R.id.hotelId);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adoption.this, adminhotel.class));
            }
        });
        CardView q = (CardView) findViewById(R.id.PlaneId);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adoption.this, adminflight.class));
            }
        });
        CardView m = (CardView) findViewById(R.id.tourid);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adoption.this, admintour.class));
            }
        });

    }
}