package nanobyte.com.drumkit;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;


public class FullscreenActivity extends AppCompatActivity {
    private static final int UI_ANIMATION_DELAY = 300;

    private MediaPlayer mp;
    private ImageView drumImage;

    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {

            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setContentView(R.layout.activity_fullscreen);
        mContentView = findViewById(R.id.drumImage);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
            hide();
        }

        drumImage = (ImageView) findViewById(R.id.drumImage);
        drumImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                handleClick((int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            }
        });
    }

    private void handleClick(int x, int y) {
        String msg = "Location : " + x + "," + y;
        Log.i("COOR", msg);

        if ((145 < x && x < 570) && (600 < y && y < 1000)) {
            playSound(R.raw.snare);
        } else {
            playSound(R.raw.cymbals);
        }
    }


    private void playSound(int id) {
        if (mp != null) {
            mp.release();
        }
        mp = MediaPlayer.create(this, id);
        mp.start();
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }
}
