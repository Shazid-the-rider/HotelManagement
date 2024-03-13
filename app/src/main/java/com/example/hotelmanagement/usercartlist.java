package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class usercartlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercartlist);
        CardView o = (CardView) findViewById(R.id.admin);
        CardView p = (CardView) findViewById(R.id.hotelId);
        CardView q = (CardView) findViewById(R.id.foodId);
        CardView r = (CardView) findViewById(R.id.PlaneId);
        CardView s = (CardView) findViewById(R.id.backid);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usercartlist.this, cartitem.class));
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usercartlist.this, carthotel.class));
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usercartlist.this, cartflight.class));
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usercartlist.this, account.class));
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(usercartlist.this, usertour.class));
            }
        });


    }
}