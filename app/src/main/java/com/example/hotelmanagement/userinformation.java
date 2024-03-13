package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class userinformation extends AppCompatActivity {
    private TableRow tr1, tr2, tr3, tr4;
    private TableLayout tl;
    private TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    String values, values1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);
        tl = (TableLayout) findViewById(R.id.table);
        tr1 = (TableRow) findViewById(R.id.titleid);
        tr2 = (TableRow) findViewById(R.id.name_title);
        tr3 = (TableRow) findViewById(R.id.key_title);
        txt1 = (TextView) findViewById(R.id.textview1);
        txt2 = (TextView) findViewById(R.id.textview2);
        txt3 = (TextView) findViewById(R.id.textview3);
        txt4 = (TextView) findViewById(R.id.textview4);
        txt5 = (TextView) findViewById(R.id.textview5);
        txt6 = (TextView) findViewById(R.id.textview6);
        txt7 = (TextView) findViewById(R.id.textview7);
        Bundle bundle = getIntent().getExtras();
        SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
        String username = sf.getString("username", "");
        if (bundle != null) {
            String values = bundle.getString("key");
            String values1 = bundle.getString("key1");
            // Logging to check values
            Log.d("UserInformationActivity", "Username: " + username);
            Log.d("UserInformationActivity", "Values: " + values);
            Log.d("UserInformationActivity", "Values1: " + values1);
            // Set text for TextViews
            txt3.setText(username);
            txt5.setText(values);
            txt7.setText(values1);
        } else {
            Log.e("UserInformationActivity", "Bundle is null");
        }
        ImageButton img = (ImageButton) findViewById(R.id.backButton);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userinformation.this, account.class));
            }
        });
    }
}
