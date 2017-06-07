package com.exampe.educationalgame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class game extends AppCompatActivity {


    private ArrayList<Computer> CelebrityList = new ArrayList<>();
    private int[] radioList = {
            R.id.radio1, R.id.radio2,
            R.id.radio3
    };
    private RadioGroup rg1;
    private Computer currentCelebrity;
    private ImageView imageView;
    private TextView scoreResult;

    private int celebrityIndex = 0;
    private int numChoices;

    private int score = 0;


    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        imageView = (ImageView) findViewById(R.id.imageView2);

        rg1 = (RadioGroup) findViewById(R.id.rg1);

        preferences = getSharedPreferences("value", MODE_PRIVATE);
        numChoices = preferences.getInt("numChoices", 3);

        createCelebrityList();
        displayCelebrity();
    }

    public void radioHandle(View view) {
        RadioButton pressed = (RadioButton) view;

        scoreResult = (TextView) findViewById(R.id.score_label);


        rg1.clearCheck();
        // Set the check after clearing all
        pressed.setChecked(true);
        String guessName = (String) pressed.getText();

        boolean result = currentCelebrity.isCorrect(guessName);
        // Perform any action desired for the new selection:
        if (currentCelebrity.isCorrect(guessName)) {
            makeToast("You are correct!");
            score ++;
            scoreResult.setText(String.valueOf(score));
            displayCelebrity();


        } else {
            makeToast("You are wrong!");
            displayCelebrity();
        }

    }

    public void createCelebrityList() {
        // fills up the arraylist CelebrityList
        ArrayList<String> guesses = new ArrayList<String>(
                Arrays.asList(
                        "CPU",
                        "RAM",
                        "GPU"

                ));
        Computer one = new Computer("CPU", R.drawable.cpuguess, guesses);
        Computer two = new Computer("RAM", R.drawable.ramguess, guesses);
        Computer three = new Computer("GPU", R.drawable.gpuguess,guesses);
        Computer four = new Computer("Internal", R.drawable.internalcomp,guesses);


        CelebrityList.add(one);
        CelebrityList.add(two);
        CelebrityList.add(three);
        CelebrityList.add(four);

    }

    public void displayCelebrity() {
        rg1.clearCheck();

        if (celebrityIndex == CelebrityList.size() - 1) {
            makeToast("Game Over");
        } else {
            currentCelebrity = CelebrityList.get(celebrityIndex);
            celebrityIndex++;

            ArrayList<String> guessList = currentCelebrity.getGuesses(numChoices);
            for (int i = 0; i < numChoices; i++) {
                RadioButton current = (RadioButton) findViewById(radioList[i]);
                current.setText(guessList.get(i));
            }

            imageView.setImageResource(currentCelebrity.getImage());
        }
    }


    public void makeToast(String n) {
        Toast.makeText(this, n, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }



}
