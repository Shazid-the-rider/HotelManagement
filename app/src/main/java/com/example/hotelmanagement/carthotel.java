
package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class carthotel extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carthotel);
        SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
        String username = sf.getString("username", "").toString();
        Database db = new Database(getApplicationContext(), "Hotel", null, 1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewid);
        ArrayList<String> dbdata = db.getcartinfo3(username);
        ArrayList<Float> dbdata1 = db.getcartinfo4(username);
        ArrayList<String> dbdata2 = db.getcartinfo5(username);

        if (dbdata.isEmpty() || dbdata1.isEmpty() || dbdata2.isEmpty()) {
            Toast.makeText(this, "No carted items found", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            recyclerView = findViewById(R.id.recyclerviewid);
            myadapter xadapter = new myadapter(this, dbdata, dbdata1, dbdata2);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(xadapter);
        }
        ImageButton im = (ImageButton) findViewById(R.id.img2);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(carthotel.this, usercartlist.class));
            }
        });


    }


}