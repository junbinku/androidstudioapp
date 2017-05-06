package com.exampe.guessinggameappdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private EditText guessField;

    private int secretNumber;

    private SharedPreferences preferences;

    private int minVal;
    private int maxVal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("value", MODE_PRIVATE);

        Random random = new Random();
        minVal = preferences.getInt("min bar",0);
        maxVal = preferences.getInt("max bar", 10);

        secretNumber = minVal + random.nextInt(maxVal-minVal);





        statusText = (TextView) findViewById(R.id.statusText);
        guessField = (EditText) findViewById(R.id.guessField);

        statusText.setText("Welcome!");

        guessField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {

                try {
                    int value = Integer.parseInt(string.toString());

                    if (value == secretNumber) {
                        statusText.setText("you won");
                    }
                }catch (Exception e) {

                    }

            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        statusText.setText("Min: " + minVal + "Max: " + maxVal);
    }

    public void buttonHandler(View view){
        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);

    }
}
