package com.example.crimereportn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button register;
    private TextView loginuser;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.email);
        password = findViewById(R.id.password);
        register=findViewById(R.id.register);
        loginuser=findViewById(R.id.login_user);

        auth =FirebaseAuth.getInstance();
        loginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class).
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();

                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                    Toast.makeText(RegisterActivity.this,"EMPTY CREDENTIALS",Toast.LENGTH_SHORT).show();

                } else if (txt_password.length()<6) {
                    Toast.makeText(RegisterActivity.this,"PASSWORD TOO SHORT",Toast.LENGTH_SHORT).show();


                }else{
                    registerUser(txt_email,txt_password);
                }
            }

            private void registerUser(String email, String password) {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"USER REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else {
                            Toast.makeText(RegisterActivity.this,"REGISTRATION FAILED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });





    }
}
