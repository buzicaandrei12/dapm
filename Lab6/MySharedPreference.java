package com.example.lab6;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;

public class MySharedPreference {
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    public MySharedPreference (Context context) {
        settings = context.getSharedPreferences("MyPref",0);
        editor = settings.edit();
    }

    public void save(String text){
        editor.putString("key_name",text);
        editor.commit();
    }

    public String getValue(){
        return settings.getString("key_name",null);
    }

    public void clearSharedPreferences(){
        editor.clear();
        editor.commit();
    }
}
