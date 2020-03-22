package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MySharedPreference pref = new MySharedPreference(MainActivity.this);
        Button btnSave = findViewById(R.id.button);
        Button btnSecondActivity = findViewById(R.id.button2);
        final EditText txt = findViewById(R.id.editText);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.save(txt.getText().toString());
            }
        });
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("name","sal");
                startActivity(intent);
            }
        });
    }
}

