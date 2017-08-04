package com.example.branden.bmicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatsPage extends AppCompatActivity {

    static final String item = "the items and stuff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page2);

        Intent display= getIntent();

        Double Height= display.getDoubleExtra(MainActivity.HEIGHT,0);
        Double Weight= display.getDoubleExtra(MainActivity.WEIGHT, 0);
        Double BMI= display.getDoubleExtra(MainActivity.BMI, 0);

        //double bmiNumber= BMI;

        TextView lbs= (TextView) (findViewById(R.id.tvWeightStat));
        TextView inches= (TextView) (findViewById(R.id.tvHeightStat));
        TextView health= (TextView) (findViewById(R.id.tvHealthStat));
        //layout s =(layout) (findViewById(R.id.loStats));

        double kg= Weight * 0.453592;
        double cm= Height * 2.54;
        double meter= Height * 0.0254;

        lbs.setText("Weight: \n"+Weight+" lbs\n"+ kg + " kg");
        inches.setText("Height: \n"+ Height+ " inches\n"+ cm +" cm\n" + meter + " m");

        if((BMI <=25) && (BMI >= 18.5))
        {
            health.setText("Good Weight");
        }
        else if(BMI < 18.5)
        {
            health.setText("UnderWeight");
        }
        else if(BMI > 25)
        {
            health.setText("OverWeight");
        }

    }

    public void onPause(){
        super.onPause();

        int numbers =5;

        Intent intent = new Intent();
        intent.putExtra(item, numbers);
        setResult(RESULT_OK, intent);
        finish();
    }
}
