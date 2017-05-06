package com.exampe.mydiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String [] quote = {"Believe in yourself","Work hard play hard","Be yourself"};
    int [] images = {R.drawable.a, R.drawable.b,R.drawable.c};
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count  = new Random().nextInt(images.length);

        getText().setText(quote[new Random().nextInt(images.length)]);
        getImage().setImageResource(images[new Random().nextInt(images.length)]);


    }

    protected ImageView getImage(){
        return (ImageView) findViewById(R.id.image);
    }

    protected TextView getText(){
        return(TextView) findViewById(R.id.textView);
    }

    public void buttonOnClick(View v) {
        if(count == 2) {
            getText().setText(quote[new Random().nextInt(images.length)]);
            getImage().setImageResource(images[new Random().nextInt(images.length)]);
            count = 0;
        }
        else if(count == 1){
            getText().setText(quote[new Random().nextInt(images.length)]);
            getImage().setImageResource(images[new Random().nextInt(images.length)]);
            count ++;
        }

        else{
            getText().setText(quote[new Random().nextInt(images.length)]);
            getImage().setImageResource(images[new Random().nextInt(images.length)]);
            count ++;

        }
    }
}