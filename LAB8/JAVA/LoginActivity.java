package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editUsername, editPassword;
    Button btnLogin;
    TextView txtRegister;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mydb = new DatabaseHelper(this);
        editUsername = (EditText) findViewById(R.id.editText_username);
        editPassword = (EditText) findViewById(R.id.editText_password);
        btnLogin = (Button) findViewById(R.id.btn_logIn);
        txtRegister = (TextView) findViewById((R.id.txtView_register));
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                boolean checked = mydb.checkUser(user,password);
                Intent mainPageIntent = new Intent(LoginActivity.this,MainActivity.class);
                if(editUsername.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter username",Toast.LENGTH_LONG).show();
                }else if(editPassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter password",Toast.LENGTH_LONG).show();
                }else if(!checked){
                    Toast.makeText(LoginActivity.this,"Username or password inccorect",Toast.LENGTH_LONG).show();
                }else{
                    startActivity(mainPageIntent);
                }

            }
        });

    }
}
