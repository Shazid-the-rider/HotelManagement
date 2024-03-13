package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class room2 extends AppCompatActivity {
    private ImageView imgView;
    private Button btn1, btn2;
    private TextView txt1, txt2, txt3;
    private ImageButton img1;
    String values, country;
    float z, t, u;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            values = bundle.getString("key1");
            country = bundle.getString("key3");
            x = bundle.getInt("key2", -1);
        }
        String[] Hom = getResources().getStringArray(R.array.Hotel_cost);
        String[] Vom = getResources().getStringArray(R.array.description);
        txt1 = (TextView) findViewById(R.id.textView1);
        imgView = (ImageView) findViewById(R.id.imageView1);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        txt2 = (TextView) findViewById(R.id.textView2);
        txt3 = (TextView) findViewById(R.id.textView3);
        img1 = (ImageButton) findViewById(R.id.imageButton1);
        TypedArray image = getResources().obtainTypedArray(R.array.images_array);
        if (x >= 0 && x < image.length()) {
            int imageResource = image.getResourceId(x, -1);
            image.recycle();
            imgView.setImageResource(imageResource);
        }
        txt3.setText(values);
        txt1.setText(Vom[x]);
        txt2.setText(Hom[x] + " $");
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(room2.this, room1.class));
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                if (db.CheckBookRoom(username, values, country) == 1) {
                    Toast.makeText(room2.this, "Booking Already Complete", Toast.LENGTH_SHORT).show();
                } else {
                    z = Float.parseFloat(Hom[x]);
                    db.book(username, values, z, country, "Hotel");
                    Toast.makeText(room2.this, "Booking Successful and created table", Toast.LENGTH_SHORT).show();

                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                if (db.CheckBookRoom(username, values, country) == 1) {
                    db.RemoveBook(username, values, country, "Hotel");
                    Toast.makeText(room2.this, "Remove Booking Complete", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(room2.this, "No such Kind of Booking", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}