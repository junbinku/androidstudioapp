package nanobyte.com.guesstheceleb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Celebrity> CelebrityList = new ArrayList<>();
    private int[] radioList = {
            R.id.radio1, R.id.radio2,
            R.id.radio3, R.id.radio4,
            R.id.radio5, R.id.radio6
    };
    private RadioGroup rg1, rg2;
    private Celebrity currentCelebrity;
    private ImageView imageView;

    private int celebrityIndex = 0;
    private int numChoices;


    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageView);

        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);

        preferences = getSharedPreferences("value", MODE_PRIVATE);
        numChoices = preferences.getInt("numChoices", 6);

        createCelebrityList();
        displayCelebrity();
    }

    public void radioHandle(View view) {
        RadioButton pressed = (RadioButton) view;

        rg1.clearCheck();
        rg2.clearCheck();
        // Set the check after clearing all
        pressed.setChecked(true);
        String guessName = (String) pressed.getText();

        boolean result = currentCelebrity.isCorrect(guessName);
        // Perform any action desired for the new selection:
        if (currentCelebrity.isCorrect(guessName)) {
            makeToast("You are correct!");
            displayCelebrity();

        } else {
            makeToast("You are wrong!");
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_LONG);
        }
    }

    public void disableRadio(int num) {
        RadioButton temp = (RadioButton) findViewById(num);
        temp.setEnabled(false);
    }

    public void enableRadio(int num) {
        RadioButton temp = (RadioButton) findViewById(num);
        temp.setEnabled(true);
    }

    public void adjustRadioButtons() {
        numChoices = preferences.getInt("numChoices", 6);
        if (numChoices == radioList.length) {
            for (int i=0; i<numChoices; i++) {
                enableRadio(radioList[i]);
            }
        } else {
            // Enable those which are under the limit
            for (int i=0; i<numChoices; i++) {
                enableRadio(radioList[i]);
            }
            // Disable those which are above the limit
            for (int i=numChoices; i<6; i++) {
                disableRadio(radioList[i]);
            }
        }

    }

    public void createCelebrityList() {
        // fills up the arraylist CelebrityList
        ArrayList<String> guesses = new ArrayList<String>(
                Arrays.asList(
                        "Summer Glau",
                        "Emma Stone",
                        "Natalie Dormer",
                        "Natalie Portman",
                        "Blake Lively",
                        "Elizabeth Olsen"
                ));
        Celebrity one = new Celebrity("Summer Glau", R.drawable.summer_glau, guesses);
        Celebrity two = new Celebrity("Natalie Dormer", R.drawable.natalie_dormer, guesses);
        Celebrity three = new Celebrity("Emma Stone", R.drawable.emma_stone, guesses);
        Celebrity four = new Celebrity("Blake Lively", R.drawable.blake_lively, guesses);
        Celebrity five = new Celebrity("Elizabeth Olsen", R.drawable.elizabeth_olsen, guesses);

        CelebrityList.add(one);
        CelebrityList.add(two);
        CelebrityList.add(three);
        CelebrityList.add(four);
        CelebrityList.add(five);
    }

    public void displayCelebrity() {
        adjustRadioButtons();
        rg1.clearCheck();
        rg2.clearCheck();

        if (celebrityIndex == CelebrityList.size() - 1) {
            makeToast("GAME OVER!!!");
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

    @Override
    protected void onRestart() {
        super.onRestart();
        celebrityIndex--;
        displayCelebrity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        return true;
    }

    public void sizeHandle(View view) {
        RadioButton current = (RadioButton) view;
        int num = Integer.valueOf((String) current.getText());

        preferences.edit()
                .putInt("numChoices", num)
                .apply();

        celebrityIndex--;
        displayCelebrity();
    }

    public void makeToast(String n) {
        Toast.makeText(this, n, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent SecondaryIntent = new Intent(this, SecondaryActivity.class);
            startActivity(SecondaryIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
