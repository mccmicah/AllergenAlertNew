package com.example.allergenalertnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Allergies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergies);


        ArrayList<String> nutFamily = new ArrayList<String>(Arrays.asList("peanuts", "treenuts", "almonds", "walnuts"));
        ArrayList<String> meatFamily = new ArrayList<String>(Arrays.asList("beef", "chicken", "pork", "turkey"));
        ArrayList<String> seaFamily = new ArrayList<String>(Arrays.asList("crab", "lobster", "salmon", "shellfish"));
        ArrayList<String> wheatFamily = new ArrayList<String>(Arrays.asList("wheat", "gluten"));
        ArrayList<String> dairyFamily = new ArrayList<String>(Arrays.asList("butter", "milk", "cream"));


        Map<String, List<String>> keywords = new HashMap<String, List<String>>();
        keywords.put("nuts", nutFamily);
        keywords.put("meat", meatFamily);
        keywords.put("seafood", seaFamily);
        keywords.put("wheat", wheatFamily);
        keywords.put("dairy", dairyFamily);

        String words = (String)getIntent().getStringExtra("words");
        words.toLowerCase();

        String[] parsed = words.split(System.lineSeparator());
        Set<String> parsedSet = new HashSet<String>(Arrays.asList(parsed));

        //TextView textView = findViewById(R.id.seeResults);
        //textView.setText(parsedSet.toString());

        Button submit = findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean detected = false;
                ArrayList<String> allTerms = new ArrayList<String>();

                CheckBox option1 = findViewById(R.id.option1);
                CheckBox option2 = findViewById(R.id.option2);
                CheckBox option3 = findViewById(R.id.option3);
                CheckBox option4 = findViewById(R.id.option4);
                CheckBox option5 = findViewById(R.id.option5);
                CheckBox option6 = findViewById(R.id.option6);
                CheckBox option7 = findViewById(R.id.option7);

                if (option1.isChecked()) {
                    allTerms.addAll(keywords.get("nuts"));
                } if (option2.isChecked()) {
                    allTerms.addAll(keywords.get("meat"));
                } if(option3.isChecked()) {
                    allTerms.addAll(keywords.get("seafood"));
                } if (option4.isChecked()) {
                    allTerms.addAll(keywords.get("wheat"));
                } if (option5.isChecked()) {
                    allTerms.addAll(keywords.get("dairy"));
                }

                Set<String> allergySet = new HashSet<String>(allTerms);

                detected = allergySet.containsAll(parsedSet);

                Context context = getApplicationContext();
                Intent intent = new Intent(context, Results.class);
                intent.putExtra("detected", detected);
                startActivity(intent);

            }
        });





    }
}