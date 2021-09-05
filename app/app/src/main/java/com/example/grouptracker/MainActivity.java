package com.example.grouptracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private EditText mail;
    private ImageButton createaccountbtn;
    private ImageButton btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerLoginBtn(savedInstanceState);
        addListenerCreateAcocountBtn(savedInstanceState);

    }

    public void addListenerLoginBtn(Bundle savedInstanceState) {

        password = (EditText) findViewById(R.id.txtPassword);
        mail = (EditText) findViewById(R.id.txtmail);
        btnSubmit = (ImageButton) findViewById(R.id.btnSubmit);
        createaccountbtn = (ImageButton) findViewById(R.id.createaccountbtn);


        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mail.getText().toString().equals("") ||  password.getText().toString().equals("")  ){
                    Toast.makeText(MainActivity.this, "Need mail or password!!",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    public void addListenerCreateAcocountBtn(Bundle savedInstanceState) {


        createaccountbtn = (ImageButton) findViewById(R.id.createaccountbtn);
        createaccountbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, CreateAccount.class);
                startActivity(intent);

            }

        });

    }


}