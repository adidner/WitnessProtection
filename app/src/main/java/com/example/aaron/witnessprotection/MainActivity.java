package com.example.aaron.witnessprotection;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LetsPlay(View view){
        startActivity(new Intent(view.getContext(), letsplay.class));
    }

    public void Roles(View view){
        startActivity(new Intent(view.getContext(), Roles.class));
    }

    public void HowToPlay(View view){
        startActivity(new Intent(view.getContext(), HowToPlay.class));
    }



}
