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

public class drinks1 extends AppCompatActivity {
    private ListView listView2;
    private ImageButton imageButton;
    private SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks1);
        imageButton = (ImageButton) findViewById(R.id.Imagebutton1);

        String[] drinkName = getResources().getStringArray(R.array.drink_name);
        String[] drinkPrice = getResources().getStringArray(R.array.drink_price);

        listView2 = findViewById(R.id.list_item1);
        DrinksAdapter adapter = new DrinksAdapter(this, drinkName, drinkPrice);
        listView2.setAdapter(adapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(drinks1.this, confirm.class);
                intent.putExtra("key", drinkName[position]);
                intent.putExtra("key1", drinkPrice[position]);
                intent.putExtra("key2", "Drinks");
                startActivity(intent);

            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(drinks1.this, food.class));
            }
        });

    }
}
