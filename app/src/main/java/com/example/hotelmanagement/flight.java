package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class flight extends AppCompatActivity {
    private ListView listView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        imageButton = (ImageButton) findViewById(R.id.Imagebutton);
        String[] flightName = getResources().getStringArray(R.array.Flight);
        String[] times = getResources().getStringArray(R.array.time);

        listView = (ListView) findViewById(R.id.list_item);
        flightadapter adapter = new flightadapter(this, flightName, times);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(flight.this, flightbook.class);
                intent.putExtra("key", flightName[position]);
                intent.putExtra("key1", times[position]);
                intent.putExtra("key2", "Flight");
                startActivity(intent);

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(flight.this, homepage.class));
            }
        });
    }
}