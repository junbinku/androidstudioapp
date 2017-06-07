package com.example.jun.drumapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.rico.drumapp.R;

public class MainActivity extends AppCompatActivity {

    private Display display;
    private SoundManager soundManager;
    private int crash, hat, kick,snare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        display = (Display) findViewById(R.id.display);
        soundManager = new SoundManager(this);
        crash = soundManager.addSound(R.raw.crash);
        hat = soundManager.addSound(R.raw.hat);
        kick = soundManager.addSound(R.raw.kick);
        snare = soundManager.addSound(R.raw.snare);
    }
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() != MotionEvent.ACTION_UP){
            return super.onTouchEvent(event);
        }
        Position position = display.getPosition(event.getX(), event.getY());

        switch (position){
            case CRASH_LEFT:
                soundManager.play(crash);
                break;
            case KICK:
                soundManager.play(kick);
                break;
            case HI_HAT:
                soundManager.play(hat);
                break;
            case SNARE:
                soundManager.play(snare);
                break;
        }
        return super.onTouchEvent(event);
    }
}
