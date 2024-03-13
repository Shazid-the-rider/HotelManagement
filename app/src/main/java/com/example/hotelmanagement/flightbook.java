package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class flightbook extends AppCompatActivity {
    private TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    private Button bt1, bt2, bt3;
    private ImageButton img1;
    private EditText edit1, edit2, edit3;
    private DatePickerDialog datePickerDialog;
    private DatePicker datePicker;
    String values, values1, values2;
    float amount, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightbook);
        txt1 = (TextView) findViewById(R.id.textView1);
        txt2 = (TextView) findViewById(R.id.textView2);
        txt3 = (TextView) findViewById(R.id.textView3);
        txt4 = (TextView) findViewById(R.id.textView4);
        txt5 = (TextView) findViewById(R.id.textView5);
        txt6 = (TextView) findViewById(R.id.textView6);
        txt7 = (TextView) findViewById(R.id.textView7);
        txt8 = (TextView) findViewById(R.id.textView8);
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);
        edit3 = (EditText) findViewById(R.id.editText3);
        img1 = (ImageButton) findViewById(R.id.imageButton1);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            values = bundle.getString("key");
            values1 = bundle.getString("key1");
            values2 = bundle.getString("key2");
        }
        txt8.setText(values1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(flightbook.this, flight.class));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "");

                String user = edit1.getText().toString();
                String mail = edit2.getText().toString();
                String num = edit3.getText().toString();

                try {
                    if (!num.isEmpty() && isNumeric(num)) {
                        number = Float.parseFloat(num);
                        String cost = txt2.getText().toString();
                        float price = Float.parseFloat(cost);
                        amount = price * number;
                        String convert = String.valueOf(amount);
                        txt4.setText(convert + " $");
                    } else {
                        Toast.makeText(flightbook.this, "Enter valid number", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    Toast.makeText(flightbook.this, "Error: Invalid input", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(flightbook.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }


        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker = new DatePicker(flightbook.this);
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH)+1;
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(flightbook.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                txt6.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, currentYear, currentMonth, currentDay);

                datePickerDialog.show();

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p, q, r, s;
                p = edit1.getText().toString();
                q = edit2.getText().toString();
                r = edit3.getText().toString();
                s = txt6.getText().toString();
                if (p.length() == 0 || q.length() == 0 || r.length() == 0 || s.length() == 0 || number == 0) {
                    Toast.makeText(flightbook.this, "Please Fill-up All information", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                    String username = sf.getString("username", "").toString();
                    String email = edit2.getText().toString();
                    String Date = txt6.getText().toString();
                    Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                    if (db.checkFlight(username, email, values, Date) == 1) {
                        Toast.makeText(flightbook.this, "flight already booked", Toast.LENGTH_SHORT).show();
                    } else {

                        db.Add_flight(username, email, values, amount, Date, "Flight");
                        Toast.makeText(flightbook.this, "Flight successfully booked", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p, q, r, s;
                p = edit1.getText().toString();
                q = edit2.getText().toString();
                r = edit3.getText().toString();
                s = txt6.getText().toString();
                String email = edit2.getText().toString();
                String Date = txt6.getText().toString();
                SharedPreferences sf = getSharedPreferences("sp", MODE_PRIVATE);
                String username = sf.getString("username", "").toString();
                Database db = new Database(getApplicationContext(), "Hotel", null, 1);
                if (db.checkFlight(username, email, values, Date) == 1) {
                    db.remove_flight(username, values, Date);
                    Toast.makeText(flightbook.this, "Remove Booking Complete", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(flightbook.this, "No such Kind of Booking", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;

    }

}