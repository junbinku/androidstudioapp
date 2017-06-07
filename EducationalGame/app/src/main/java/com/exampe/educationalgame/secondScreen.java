package com.exampe.educationalgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class secondScreen extends AppCompatActivity {

    int clickImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        final ImageView imageview = (ImageView) findViewById(R.id.imageView1);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (clickImage) {
                    case 0:
                        imageview.setImageResource(R.drawable.cpu);
                        ++ clickImage;
                        break;
                    case 1:
                        imageview.setImageResource(R.drawable.gpu);
                        ++ clickImage;
                        break;
                }
            }
        });


    }

    public void activity2(View view)
    {
        Intent intent2 = new Intent(this, game.class);
        startActivity(intent2);

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
