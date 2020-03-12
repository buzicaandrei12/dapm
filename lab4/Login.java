package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private static String USERNAME = "student";
    private static String PASSWORD = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.button);
        final EditText user = findViewById(R.id.editText);
        final EditText pass = findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals(USERNAME) && pass.getText().toString().equals(PASSWORD))
                {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Login.this,"Username or password incorrect", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
