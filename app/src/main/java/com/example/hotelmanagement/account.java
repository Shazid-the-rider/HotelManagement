package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class account extends AppCompatActivity {
    String Username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        CardView logout = (CardView) findViewById(R.id.logoutid);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account.this, loginpage.class));
            }
        });
        CardView use = (CardView) findViewById(R.id.admin);
        use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "");
                String usercode = sf.getString("usercode", "");
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                String Email;
                String Password;
                ArrayList dbdata = db.getuserinfo(usercode);
                String x = dbdata.get(0).toString();
                String y = dbdata.get(1).toString();
                Intent intent = new Intent(account.this, userinformation.class);
                intent.putExtra("key", x);
                intent.putExtra("key1", y);
                startActivity(intent);
            }
        });
        CardView use1 = (CardView) findViewById(R.id.foodId);
        use1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account.this, updateinfo.class));
            }
        });
        CardView use2 = (CardView) findViewById(R.id.hotelId);
        use2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account.this, usercartlist.class));
            }
        });
        CardView c = (CardView) findViewById(R.id.backid);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(account.this, homepage.class));
            }
        });

    }
}