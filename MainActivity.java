package com.example.crimereportn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickListener();
        auth=FirebaseAuth.getInstance();


    }


    public void clickListener() {
        CardView CD1 = findViewById(R.id.cd1);
        CardView CD2 = findViewById(R.id.cd2);
        CardView CD3 = findViewById(R.id.cd3);
        CardView CD4 = findViewById(R.id.cd4);
        CardView CD5 = findViewById(R.id.cd5);
        CardView CD6 = findViewById(R.id.cd6);
        Button button = findViewById(R.id.logout);
        CD1.setOnClickListener(view -> openCd1());
        CD2.setOnClickListener(view -> openCd2());
        CD3.setOnClickListener(view -> openCd3());
        CD4.setOnClickListener(view -> openCd4());
        CD5.setOnClickListener(view -> openCd5());
        CD6.setOnClickListener(view -> openCd6());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    public void openCd1() {
        startActivity(new Intent(this, cd1.class));
    }

    public void openCd2() {
        startActivity(new Intent(this, cd2.class));
    }
    public void openCd3() {
        startActivity(new Intent(this, cd3.class));
    }

    public void openCd4() {
        startActivity(new Intent(this, cd4.class));
    }
    public void openCd5() {
        startActivity(new Intent(this, cd5.class));
    }

    public void openCd6() {
        startActivity(new Intent(this, cd6.class));
    }

}

