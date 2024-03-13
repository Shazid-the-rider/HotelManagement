package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class room1 extends AppCompatActivity {
    private ListView listview;
    private ImageButton img1;
    private SearchView searchview;
    String values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room1);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            values = bundle.getString("key");
        }

        img1 = (ImageButton) findViewById(R.id.Imagebutton);
        listview = (ListView) findViewById(R.id.list_item);
        searchview = findViewById(R.id.searchView);

        String[] room_name = getResources().getStringArray(R.array.Hotel_Name);
        listview = (ListView) findViewById(R.id.list_item);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.sampleview, R.id.textview, room_name);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(room1.this, room2.class);
                intent.putExtra("key1", room_name[position]);
                intent.putExtra("key2", position);
                intent.putExtra("key3", values);
                startActivity(intent);
            }
        });
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText); // Apply filter to adapter
                return false;
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(room1.this, room.class));
            }
        });
    }
}