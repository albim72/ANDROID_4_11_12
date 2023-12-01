package com.marcin.boot_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (Intent.ACTION_BOOT_COMPLETED != null){
            Toast.makeText(this, "Serwis jest ładowany!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Problem z ładowaniem!", Toast.LENGTH_SHORT).show();
        }
    }
}
