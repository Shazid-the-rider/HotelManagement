package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class updateinfo extends AppCompatActivity {
    private TextView txt;
    private EditText txt1, txt2, txt3, txt4, txt5, txt6;
    private Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Database db = new Database(getApplicationContext(), "Hotel", null, 1);
        setContentView(R.layout.activity_updateinfo);
        txt = (TextView) findViewById(R.id.textView);
        txt1 = (EditText) findViewById(R.id.signupUserNameid);
        txt2 = (EditText) findViewById(R.id.signupUserNameid1);
        txt5 = (EditText) findViewById(R.id.signupPasswordid2);
        txt6 = (EditText) findViewById(R.id.signupPasswordid);
        bt1 = (Button) findViewById(R.id.signupbuttonid);
        bt2 = (Button) findViewById(R.id.signupbuttonid1);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(updateinfo.this, account.class));
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = txt1.getText().toString();//present name
                String b = txt2.getText().toString();//new name
                String e = txt5.getText().toString();//present pass
                String f = txt6.getText().toString();//new pass
                boolean updated = db.updateUserInfo(a,b,e, f);
                if (updated) {
                    Toast.makeText(updateinfo.this, "Information updated successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(updateinfo.this, loginpage.class));
                } else {
                    Toast.makeText(updateinfo.this, "Failed to update information", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}