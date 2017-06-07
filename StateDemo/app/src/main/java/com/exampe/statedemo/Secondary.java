package com.exampe.statedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.content.SharedPreferences;
import android.util.Log;

public class Secondary extends AppCompatActivity {

    private SeekBar seekBar;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        preferences = getSharedPreferences("value", MODE_PRIVATE);

        Log.i("Secondary", "on create called");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Secondary", "on start called");
        int progress = preferences.getInt("seek bar", 0);
        seekBar.setProgress(progress);


    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Secondary", "on stop called");

        preferences.edit().putInt("seek bar", seekBar.getProgress())
                .apply();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log .i("Secondary", "on destroy called");

    }


}
