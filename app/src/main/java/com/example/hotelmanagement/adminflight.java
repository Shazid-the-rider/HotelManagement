package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class adminflight extends AppCompatActivity {
    RecyclerView cartRecyclerView;
    adminflightadapter adapter;
    Database database;
    private ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminflight);
        cartRecyclerView = findViewById(R.id.recyclerviewid);
        database = new Database(this, "Hotel", null, 1);

        ArrayList<String> usersWithProducts = new ArrayList<>();

        // Fetch usernames with products from the cart table
        try {
            usersWithProducts = database.getAllUsernamesWithProductsFromFlight();
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        adapter = new adminflightadapter(this, usersWithProducts);
        cartRecyclerView.setAdapter(adapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        img = (ImageButton) findViewById(R.id.img2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminflight.this, adoption.class));
            }
        });
    }

}
