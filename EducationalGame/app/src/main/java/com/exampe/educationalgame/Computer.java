package com.exampe.educationalgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class Computer extends AppCompatActivity {
    String name;
    int image;
    ArrayList<String> guesses = new ArrayList<>();


    Computer(String name, int imageID, ArrayList<String> guesses) {
        this.name = name;
        this.image = imageID;
        this.guesses = guesses;
    }

    public ArrayList<String> getGuesses(int num) {

        if (num == this.guesses.size()) {
            Collections.shuffle(this.guesses);
            return this.guesses;
        } else {
            ArrayList<String> result = new ArrayList<>();
            // to ensure the correct result is always in the choices
            result.add(this.name);

            Collections.shuffle(guesses);

            int count = num;
            for (int i = 0; i < count; i++) {
                String temp = guesses.get(i).toString();
                if (result.contains(temp))
                    count++;
                else
                    result.add(temp);
            }
            Collections.shuffle(result);
            return result;
        }

    }

    public boolean isCorrect(String name) {
        boolean result = this.name.equals(name);
        return result;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

}

