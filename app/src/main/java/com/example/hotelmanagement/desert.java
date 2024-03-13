package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class desert extends AppCompatActivity {
    private ListView listView;
    private ImageButton imageButton;
    private SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert);
        imageButton = (ImageButton) findViewById(R.id.Imagebutton);
        String[] desertNames = getResources().getStringArray(R.array.desert_name);
        String[] costs = getResources().getStringArray(R.array.cost);

        listView = findViewById(R.id.list_item);
        CustomAdapter adapter = new CustomAdapter(this, desertNames, costs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(desert.this, confirm.class);
                intent.putExtra("key", desertNames[position]);
                intent.putExtra("key1", costs[position]);
                intent.putExtra("key2", "Desert");
                startActivity(intent);

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(desert.this, food.class));
            }
        });

    }
}
