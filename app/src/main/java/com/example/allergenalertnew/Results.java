package com.example.allergenalertnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Boolean detected = getIntent().getBooleanExtra("detected", false);

        TextView textView = findViewById(R.id.results);
        textView.setText(detected.toString());
    }
}