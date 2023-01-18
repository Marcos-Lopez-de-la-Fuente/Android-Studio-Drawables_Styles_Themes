package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView team1Score;

    ImageButton team1Increment;
    ImageButton team1Decrement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.team1Score = this.findViewById(R.id.team1Score);
        this.team1Increment = this.findViewById(R.id.team1Increment);
        this.team1Decrement = this.findViewById(R.id.team1Decrement);


        this.team1Score.setText(0);

        this.team1Increment.setOnClickListener(view -> this.increaseScore(this.team1Score));
        this.team1Decrement.setOnClickListener(view -> this.decreaseScore(this.team1Score));


    }


    private void increaseScore(TextView textView) {

        textView.setText(Integer.parseInt((String) textView.getText()) + 1);

    }


    private void decreaseScore(TextView textView) {

        if (Integer.parseInt((String) textView.getText()) > 0) {
            textView.setText(Integer.parseInt((String) textView.getText()) - 1);
        }

    }


}