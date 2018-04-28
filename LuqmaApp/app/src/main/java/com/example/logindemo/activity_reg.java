package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_reg extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        setupUIViews();

        regButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(validate()){
                 //database
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_reg.this, MainActivity.class));
            }
        });
    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUName);
        userPassword= (EditText)findViewById(R.id.etUPassword);
        userEmail= (EditText)findViewById(R.id.etUEmail);
        regButton = (Button)findViewById(R.id.bUSignUp);
        userLogin = (TextView)findViewById(R.id.tvULogin);


    }

    private Boolean validate() {
        Boolean result = false;
        String n = userName.getText().toString();
        String p = userPassword.getText().toString();
        String e = userEmail.getText().toString();

        if (n.isEmpty() && p.isEmpty() && e.isEmpty()) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }else
        {
            result= true;
        }

        return result;
    }

}
