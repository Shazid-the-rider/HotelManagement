package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class touractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touractivity);
        CardView p = (CardView) findViewById(R.id.admin);
        CardView q = (CardView) findViewById(R.id.hotelId);
        CardView r = (CardView) findViewById(R.id.foodId);
        CardView s = (CardView) findViewById(R.id.PlaneId);
        CardView t = (CardView) findViewById(R.id.accountid);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(touractivity.this, bookconfirm.class);
                intent.putExtra("key", "Paragliding");
                intent.putExtra("key1", "280");
                startActivity(intent);
            }
        });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(touractivity.this, bookconfirm.class);
                intent.putExtra("key", "Hiking");
                intent.putExtra("key1", "155");
                startActivity(intent);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(touractivity.this, bookconfirm.class);
                intent.putExtra("key", "Movies");
                intent.putExtra("key1", "75");
                startActivity(intent);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(touractivity.this, bookconfirm.class);
                intent.putExtra("key", "Surfing");
                intent.putExtra("key1", "225");
                startActivity(intent);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(touractivity.this, homepage.class));
            }
        });


    }
}