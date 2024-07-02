package com.example.hotelmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.UUID;

public class signuppage extends AppCompatActivity {
    private EditText usernAme, eMail, paSsword, conFirmpassword;
    private TextView teXtView;
    private Button signup;
    private FirebaseAuth mAuth;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        mAuth = FirebaseAuth.getInstance();
        db = new Database(getApplicationContext(), "Hotel", null, 1);

        usernAme = findViewById(R.id.signupUserNameid);
        eMail = findViewById(R.id.signupEmailid);
        paSsword = findViewById(R.id.signupPasswordid);
        conFirmpassword = findViewById(R.id.signupPasswordid2);
        signup = findViewById(R.id.signupbuttonid);
        teXtView = findViewById(R.id.signuptextViewid);

        teXtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signuppage.this, loginpage.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernAme.getText().toString().trim();
                String email = eMail.getText().toString().trim();
                String password = paSsword.getText().toString().trim();
                String cpassword = conFirmpassword.getText().toString().trim();

                if (email.isEmpty()) {
                    eMail.setError("Enter an email address");
                    eMail.requestFocus();
                    return;
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    eMail.setError("Enter a valid email address");
                    eMail.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    paSsword.setError("Enter a password");
                    paSsword.requestFocus();
                    return;
                }
                if (password.length() < 8) {
                    paSsword.setError("Minimum length of password should be 8");
                    paSsword.requestFocus();
                    return;
                }
                if (!password.equals(cpassword)) {
                    conFirmpassword.setError("Passwords do not match");

                    conFirmpassword.requestFocus();
                    return;
                }
                if (!isValid(password)) {
                    Toast.makeText(signuppage.this, "Password must contain at least one letter, one number, and one special character", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create user with email and password
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signuppage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Registration successful, proceed to save user details in database
                                    String usercode = UUID.randomUUID().toString();
                                    db.register(name, usercode, email, password);
                                    Toast.makeText(signuppage.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(signuppage.this, loginpage.class);
                                    intent.putExtra("key", usercode);
                                    startActivity(intent);
                                } else {
                                    // Registration failed
                                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(signuppage.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(signuppage.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
        });
    }

    public static boolean isValid(String pass) {
        // Validate password criteria
        return pass.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{8,}$");
    }
}
