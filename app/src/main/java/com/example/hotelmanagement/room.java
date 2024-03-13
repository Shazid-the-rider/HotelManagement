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

public class room extends AppCompatActivity {
    private ListView listview;
    private ImageButton img1;
    private SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        listview = (ListView) findViewById(R.id.list_item);
        String[] country_name = getResources().getStringArray(R.array.location);
        listview = (ListView) findViewById(R.id.list_item);
        img1 = (ImageButton) findViewById(R.id.Imagebutton);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.sampleview, R.id.textview, country_name);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(room.this, room1.class);
                intent.putExtra("key", country_name[position]);
                startActivity(intent);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(room.this, homepage.class));
            }
        });
        searchview = findViewById(R.id.searchView);
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
    }
}