package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MySharedPreference mySharedPreference = new MySharedPreference(Main2Activity.this);
        TextView txt = findViewById(R.id.textView);
        txt.setText(mySharedPreference.getValue() + getIntent().getStringExtra("name"));
    }
}
