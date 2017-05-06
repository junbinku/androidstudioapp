package com.exampe.guessinggameappdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondaryActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar minBar;
    private SeekBar maxBar;
    private TextView minNum;
    private TextView maxNum;

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        preferences = getSharedPreferences("value", MODE_PRIVATE);

        minBar = (SeekBar) findViewById(R.id.minBar);
        maxBar =(SeekBar) findViewById(R.id.maxBar);

        minNum = (TextView) findViewById(R.id.minNum);
        maxNum = (TextView) findViewById(R.id.maxNum);

        minBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String textValue = String.valueOf(progress);
                minNum.setText(textValue);

                preferences.edit().putInt("min bar", minBar.getProgress()).apply();



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        maxBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String textValue = String.valueOf(progress);
                maxNum.setText(textValue);

                preferences.edit().putInt("max bar", maxBar.getProgress()).apply();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }


    public void buttonHandler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

