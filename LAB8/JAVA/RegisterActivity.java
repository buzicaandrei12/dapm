package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    com.example.lab8.DatabaseHelper mydb;
    EditText editUsername, editPassword, editCnfPassword,editName,editSurname,editSex;
    Button btnRegister;
    TextView txtLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mydb = new com.example.lab8.DatabaseHelper(this);
        editUsername = (EditText) findViewById(R.id.editText_username);
        editPassword = (EditText) findViewById(R.id.editText_password);
        editCnfPassword = (EditText) findViewById(R.id.editText_passwordCnf);
        btnRegister = (Button) findViewById(R.id.btn_register);
        txtLogIn = (TextView) findViewById((R.id.txtView_login));
        editName = (EditText) findViewById(R.id.editText_nume);
        editSurname = (EditText) findViewById(R.id.editText_prenume);
        editSex = (EditText) findViewById(R.id.editText_sex);

        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                String user = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String name = editName.getText().toString().trim();
                String surname = editSurname.getText().toString().trim();
                String sex = editSex.getText().toString().trim();
                boolean checked = mydb.checkUser(user,password);
                if(!checked){
                        if(editUsername.getText().toString().equals("")){
                            Toast.makeText(RegisterActivity.this,"Please enter username",Toast.LENGTH_LONG).show();
                        }else if(editPassword.getText().toString().equals("")){
                            Toast.makeText(RegisterActivity.this,"Please enter password",Toast.LENGTH_LONG).show();
                        }else if(editCnfPassword.getText().toString().equals("")){
                            Toast.makeText(RegisterActivity.this,"Please confirm password",Toast.LENGTH_LONG).show();
                        }else if(!editCnfPassword.getText().toString().equals(editPassword.getText().toString())) {
                            Toast.makeText(RegisterActivity.this, "Passwords don't match", Toast.LENGTH_LONG).show();
                        }else if(editName.getText().toString().equals("")){
                            Toast.makeText(RegisterActivity.this, "Please enter Name", Toast.LENGTH_LONG).show();
                        }else if(editSurname.getText().toString().equals("")){
                            Toast.makeText(RegisterActivity.this, "Please enter Surname", Toast.LENGTH_LONG).show();
                        }else if(editSex.getText().toString().equals("")){
                            Toast.makeText(RegisterActivity.this, "Please enter Sex", Toast.LENGTH_LONG).show();
                        } else{
                            long val = mydb.addUser(user,password,name,surname,sex);
                            if(val>0){
                                Toast.makeText(RegisterActivity.this, "Registered!", Toast.LENGTH_LONG).show();
                                startActivity(loginIntent);
                            }
                        }
                    }else{
                    Toast.makeText(RegisterActivity.this, "Account already exists", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



}
