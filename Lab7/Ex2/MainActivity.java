package com.example.lab7p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectFrag(View view) {
        FragmentOne fr1;
        FragmentTwo fr2;

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        if(view == findViewById(R.id.button2)) {
            fr2 = new FragmentTwo();
            fragmentTransaction.replace(R.id.fragment_place, fr2);

        }else {
            fr1 = new FragmentOne();
            fragmentTransaction.replace(R.id.fragment_place, fr1);
        }



        fragmentTransaction.commit();

    }

}
