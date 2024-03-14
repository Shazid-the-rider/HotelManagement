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

public class confirm extends AppCompatActivity {
    private Button buttoN1, buttoN2, buttoN3;
    private TextView textview1, textview2, textview3, textview4;
    private EditText textedit1;
    private ImageButton img1;


    String values, values1, values2;
    float y, z, x;
    String s, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            values = bundle.getString("key");
            values1 = bundle.getString("key1");
            values2 = bundle.getString("key2");
        }
        buttoN1 = (Button) findViewById(R.id.button1);
        buttoN2 = (Button) findViewById(R.id.button2);
        buttoN3 = (Button) findViewById(R.id.button3);
        textview1 = (TextView) findViewById(R.id.textView1);
        textview2 = (TextView) findViewById(R.id.textView2);
        textview3 = (TextView) findViewById(R.id.textView3);
        textview4 = (TextView) findViewById(R.id.textView4);
        textedit1 = (EditText) findViewById(R.id.edittexttext1);
        img1 = (ImageButton) findViewById(R.id.imageId);
        textview1.setText(values2);
        textview2.setText("Name :" + "  " + values);
        textview3.setText("Price:" + "  " + values1);
        buttoN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    y = Float.parseFloat(values1);
                    String inputText = textedit1.getText().toString().trim();
                    if (!inputText.isEmpty() && isNumeric(inputText)) {
                        s = inputText;
                        z = Float.parseFloat(s);
                        x = y * z;
                        t = String.valueOf(x);
                        textview4.setText(t + " " + "$");
                    } else {
                        Toast.makeText(confirm.this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(confirm.this, "Error: Invalid input", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(confirm.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttoN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = textedit1.getText().toString().trim();
                if (t.isEmpty()) {
                    Toast.makeText(confirm.this, "invalid amount!please enter an amount ", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                    String usercode = sf.getString("usercode", "").toString();
                    String username = sf.getString("username", "").toString();
                    float price = x;
                    Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                    if (db.CheckCartItem(usercode, values) == 1) {
                        Toast.makeText(confirm.this, "Product already added to cart", Toast.LENGTH_SHORT).show();
                    } else {

                        db.AddCart(username,usercode, values, price, values2);
                        Toast.makeText(confirm.this, "Cart Added Successful and created table", Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });
        buttoN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "").toString();
                String usercode = sf.getString("usercode", "").toString();
                float price = x;
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                if (db.CheckCartItem(usercode, values) == 1) {
                    db.RemoveCart(usercode, values, values2);
                    Toast.makeText(confirm.this, "Product successfully removed from cart", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(confirm.this, "Item didn't find in cart", Toast.LENGTH_SHORT).show();

                }

            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(confirm.this, food.class));
            }
        });
    }

    private boolean isNumeric(String str) {
        try {
            float floatValue = Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}