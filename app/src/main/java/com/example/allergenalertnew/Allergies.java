package com.example.allergenalertnew;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class Allergies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);

        String words = (String)getIntent().getStringExtra("words");

        TextView textView = findViewById(R.id.results);

        textView.setText(words);

    }
}