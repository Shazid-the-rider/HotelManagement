package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class bookconfirm extends AppCompatActivity {
    String values, values1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookconfirm);
        TextView txt1 = (TextView) findViewById(R.id.LoginUsernameid);
        EditText txt2 = (EditText) findViewById(R.id.LoginUsernameid1);
        TextView tv1 = (TextView) findViewById(R.id.textView12);
        TextView tv2 = (TextView) findViewById(R.id.textView11);
        Button bt1 = (Button) findViewById(R.id.buttonid);
        Button bt2 = (Button) findViewById(R.id.buttonid2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            values = bundle.getString("key");
            values1 = bundle.getString("key1");
        }
        String t;
        Float z;
        tv1.setText(values1);
        tv2.setText(values);
        z = Float.parseFloat(values1);
        SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
        String username = sf.getString("username", "").toString();
        txt1.setText(username);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = txt2.getText().toString();
                if (st.length() == 0) {
                    Toast.makeText(bookconfirm.this, "Please fill up all information", Toast.LENGTH_SHORT).show();
                } else {
                    //String username, String email, float price, String Otype
                    Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                    if (db.CheckTourItem(username, values) == 1) {
                        Toast.makeText(bookconfirm.this, "Book already done", Toast.LENGTH_SHORT).show();
                    } else {
                        db.booktour(username, st, z, values);
                        Toast.makeText(bookconfirm.this, "Book successfully completed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                if (db.CheckTourItem(username, values) == 1) {
                    db.RemoveTourCart(username, values);
                    Toast.makeText(bookconfirm.this, "Book Cancel done", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(bookconfirm.this, "Book never done", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageButton img = (ImageButton) findViewById(R.id.Imagebutton);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bookconfirm.this, touractivity.class));
            }
        });


    }
}