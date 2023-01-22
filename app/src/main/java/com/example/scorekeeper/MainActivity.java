package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView team1Score;
    ImageButton team1Increment;
    ImageButton team1Decrement;

    TextView team2Score;
    ImageButton team2Increment;
    ImageButton team2Decrement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.team1Score = this.findViewById(R.id.team1Score);
        this.team1Increment = this.findViewById(R.id.team1Increment);
        this.team1Decrement = this.findViewById(R.id.team1Decrement);

        this.team2Score = this.findViewById(R.id.team2Score);
        this.team2Increment = this.findViewById(R.id.team2Increment);
        this.team2Decrement = this.findViewById(R.id.team2Decrement);


        this.team1Score.setText("0");
        this.team2Score.setText("0");


        this.team1Increment.setOnClickListener(view -> this.increaseScore(this.team1Score));
        this.team1Decrement.setOnClickListener(view -> this.decreaseScore(this.team1Score));

        this.team2Increment.setOnClickListener(view -> this.increaseScore(this.team2Score));
        this.team2Decrement.setOnClickListener(view -> this.decreaseScore(this.team2Score));


        if (savedInstanceState != null) {
            int mScore1 = savedInstanceState.getInt("STATE_SCORE_1");
            int mScore2 = savedInstanceState.getInt("STATE_SCORE_2");

            this.team1Score.setText(String.valueOf(mScore1));
            this.team2Score.setText(String.valueOf(mScore2));
        }


    }


    private void increaseScore(TextView textView) {

        int scoreBefore = Integer.parseInt((String) textView.getText());
        textView.setText(String.valueOf(scoreBefore + 1));

    }


    private void decreaseScore(TextView textView) {

        if (Integer.parseInt((String) textView.getText()) > 0) {

            int scoreBefore = Integer.parseInt((String) textView.getText());
            textView.setText(String.valueOf(scoreBefore - 1));

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.night_mode) {

            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            recreate();

        }


        return true;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("STATE_SCORE_1", Integer.parseInt((String) this.team1Score.getText()));
        outState.putInt("STATE_SCORE_2", Integer.parseInt((String) this.team2Score.getText()));


        super.onSaveInstanceState(outState);
    }

}