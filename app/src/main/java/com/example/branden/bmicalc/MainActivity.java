package com.example.branden.bmicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String WEIGHT = "Temp1";
    public static final String HEIGHT = "Temp2";
    public static final String BMI = "Temp3";


    double numAns = 0;

    static final int requestItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void Calculate(View v) {

        EditText Wlbs = (EditText) findViewById(R.id.etWeight);
        EditText Hfeet = (EditText) findViewById(R.id.etHeightFeet);
        EditText Hinches = (EditText) findViewById(R.id.etHeightInches);
        TextView bmi = (TextView) findViewById(R.id.tvResults);

        String ans;

        //creates variables
        double lbs = Integer.valueOf(Wlbs.getText().toString());
        double feet = Integer.valueOf(Hfeet.getText().toString());
        double inches = Integer.valueOf(Hinches.getText().toString());
        double height = (feet * 12) + inches;

        //the math
        lbs *= 0.45;
        height *= 0.025;
        height = height * height;
        numAns = lbs / height;
        ans = String.format("%4.2f", (lbs / height));

        bmi.setText("BMI: " + ans);
    }

    public void ShowStats(View v) {

        EditText Wlbs = (EditText) findViewById(R.id.etWeight);
        EditText Hfeet = (EditText) findViewById(R.id.etHeightFeet);
        EditText Hinches = (EditText) findViewById(R.id.etHeightInches);

        Intent stats = new Intent(this, StatsPage.class);
        double Weight = Integer.valueOf(Wlbs.getText().toString());
        double feet = Integer.valueOf(Hfeet.getText().toString());
        double inches = Integer.valueOf(Hinches.getText().toString());
        double Height = (feet * 12) + inches;

        stats.putExtra(WEIGHT, Weight);
        stats.putExtra(HEIGHT, Height);
        stats.putExtra(BMI, numAns);

        //btnStats.setText(Height);

        startActivityForResult(stats, requestItem);
        //startActivity(stats);
    }
}
