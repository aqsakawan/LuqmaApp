package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Jade_mainpage extends AppCompatActivity {
    private Button ReserveNow;
    private Button Signout;
    private Button Back;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jade_mainpage);

        ReserveNow =  (Button)findViewById(R.id.button_reserve);
        ReserveNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Jade_mainpage.this, Reserve.class));
            }
        });

        Signout = (Button)findViewById(R.id.SignOut);

        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Toast.makeText(Jade_mainpage.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Jade_mainpage.this, MainActivity.class));
            }
        });

        Back= (Button)findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Jade_mainpage.this, Search_activity.class));
            }
        });

    }
}
