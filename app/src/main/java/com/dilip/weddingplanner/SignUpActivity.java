package com.dilip.weddingplanner;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword, editTextUsername;
    Button btn_signUp, btn_login;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;


    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //checkUser();
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPassword);
        editTextUsername = findViewById(R.id.etUsername);
        btn_signUp = findViewById(R.id.btnSignUp);
        btn_login = findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                if(email.isEmpty() || password.isEmpty() || username.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(SignUpActivity.this, "Sign up success", Toast.LENGTH_SHORT).show();
                            goHome(email);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignUpActivity.this, "Sign up failed." + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
    public void goHome(String email){
        Intent intent;
        if (email.equals("admin@gmail.com")) {
             intent = new Intent(SignUpActivity.this, AdminActivity.class);
        }else {
             intent = new Intent(SignUpActivity.this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }
    private void checkUser() {
        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Intent intent;
                if(firebaseAuth.getCurrentUser() == null){
                    Log.d(TAG,"user not sign");
                    intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                }else {
//                    if (currentUser.getEmail().equals("admin@gmail.com")) {
//                        intent = new Intent(SignUpActivity.this, AdminActivity.class);
//                    }else {
//                        intent = new Intent(SignUpActivity.this, MainActivity.class);
//                    }
                }
//                startActivity(intent);
//                finish();
            }
        });
    }
}