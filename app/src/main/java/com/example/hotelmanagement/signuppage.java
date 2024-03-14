package com.example.hotelmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;


public class signuppage extends AppCompatActivity {
    private EditText usernAme, eMail, paSsword, conFirmpassword;
    private TextView teXtView;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        usernAme = (EditText) findViewById(R.id.signupUserNameid);
        eMail = (EditText) findViewById(R.id.signupEmailid);
        paSsword = (EditText) findViewById(R.id.signupPasswordid);
        conFirmpassword = (EditText) findViewById(R.id.signupPasswordid2);
        signup = (Button) findViewById(R.id.signupbuttonid);
        teXtView = (TextView) findViewById(R.id.signuptextViewid);
        Database db = new Database(getApplicationContext(), "Hotel", null, 1);

        teXtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signuppage.this, loginpage.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UUID uniqueId = UUID.randomUUID();
                String usercode= uniqueId.toString();
                String name = usernAme.getText().toString();
                String email = eMail.getText().toString();
                String password = paSsword.getText().toString();
                String cpassword = conFirmpassword.getText().toString();

                if (usernAme.length() == 0 || email.length() == 0 || password.length() == 0 || cpassword.length() == 0) {
                    Toast.makeText(signuppage.this, " Information Missing", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(cpassword) == 0) {
                        if (isValid(password)) {
                            db.register(name,usercode, email, password);
                            Toast.makeText(signuppage.this, "Signup successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signuppage.this, loginpage.class);
                            intent.putExtra("key", usercode);
                            startActivity(intent);
                        } else {
                            Toast.makeText(signuppage.this, "Password must be contained Character,Number and Syntax ", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(signuppage.this, "Password didn't match ! ", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    public static boolean isValid(String pass) {
        int x = 0, y = 0, z = 0;
        if (pass.length() < 8) {
            return false;
        } else {
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isLetter(pass.charAt(i))) ;
                {
                    x = 1;
                }
            }
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isDigit(pass.charAt(i))) {
                    y = 1;
                }
            }
            for (int i = 0; i < pass.length(); i++) {
                char c = pass.charAt(i);
                if (c >= 33 && c <= 46 || c == 64) {
                    z = 1;
                }
            }
            if (x == 1 && y == 1 && z == 1) {
                return true;
            } else {
                return false;
            }
        }

    }
}

