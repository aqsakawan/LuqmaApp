package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button RegisterButton;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etUPassword);
        Info= (TextView)findViewById(R.id.textView3);
        Login = (Button)findViewById(R.id.btnLogin);
        RegisterButton = (Button) findViewById(R.id.RegisterButton);


        Info.setText("No of attempts left: 5");
        //validates if username and password
        Login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_reg.class);
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Aqsa")) && (userPassword.equals("1234"))){
            //user to enter
            Intent intent = new Intent(MainActivity.this, activity_reg.class);
            startActivity(intent);
        }
        else{
            counter--;

            Info.setText("No. of attempts left: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
