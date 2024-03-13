package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class lunch extends AppCompatActivity {
    private ListView listView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        imageButton = (ImageButton) findViewById(R.id.Imagebutton1);
        String[] lunchnames = getResources().getStringArray(R.array.lunch_menu);
        String[] lunchcosts = getResources().getStringArray(R.array.lunch_cost);

        listView = findViewById(R.id.list_item1);
        CustomAdapter adapter = new CustomAdapter(this, lunchnames, lunchcosts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(lunch.this, confirm.class);
                intent.putExtra("key", lunchnames[position]);
                intent.putExtra("key1", lunchcosts[position]);
                intent.putExtra("key2", "Rice");
                startActivity(intent);

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(lunch.this, food.class));
            }
        });
    }
}