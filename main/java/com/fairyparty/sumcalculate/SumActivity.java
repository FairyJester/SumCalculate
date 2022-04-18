package com.fairyparty.sumcalculate;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SumActivity extends AppCompatActivity {
    int count;
    int secondCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        Intent intent = getIntent();
        count = intent.getIntExtra("count",count);
        secondCount = intent.getIntExtra("secondCount", secondCount);
        TextView counterView = findViewById(R.id.SumView);
        if (secondCount<0){
            counterView.setText(count + " + " +"("+ secondCount + ")" + " = " + (count+secondCount));
        }
        else{
            counterView.setText(count + " + " + secondCount + " = " + (count+secondCount));
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.SumView);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
            count = savedInstanceState.getInt("Count");
            secondCount = savedInstanceState.getInt("secondCount");
        }
    }
}