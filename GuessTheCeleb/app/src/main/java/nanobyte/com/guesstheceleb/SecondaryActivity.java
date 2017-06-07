package nanobyte.com.guesstheceleb;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SecondaryActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        preferences = getSharedPreferences("value", MODE_PRIVATE);
    }

    public void sizeHandle(View view) {
        RadioButton current = (RadioButton) view;
        int num = Integer.valueOf((String) current.getText());

        preferences.edit()
                .putInt("numChoices", num)
                .apply();
    }
}
