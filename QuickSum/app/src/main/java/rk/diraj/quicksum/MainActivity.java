package rk.diraj.quicksum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView totalText;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button clear_button;
    private Button other_button;

    private double totalValue = 0.0;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalText = (TextView) findViewById(R.id.totalText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        clear_button = (Button) findViewById(R.id.clear_button);
        other_button = (Button) findViewById(R.id.other_button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button1.getText().equals("1"))
                    totalValue += 1.0;
                else {
                    totalValue += 0.5;
                }
                updateDisplay();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2.getText().equals("2"))
                    totalValue += 2.0;
                else {
                    ++counter;
                    if (counter < 3)
                        totalValue += 0.33;
                    else {
                        totalValue += 0.34;
                    }
                }
                updateDisplay();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3.getText().equals("3"))
                    totalValue += 3.0;
                else {
                    totalValue += 0.25;
                }
                updateDisplay();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button4.getText().equals("4"))
                    totalValue += 4.0;
                else {
                    totalValue += 0.2;
                }
                updateDisplay();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button5.getText().equals("5"))
                    totalValue += 5.0;
                else {
                    totalValue += 0.16;

                }
                updateDisplay();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button6.getText().equals("6"))
                    totalValue += 6.0;
                else {
                    totalValue += 0.14;
                }
                updateDisplay();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button7.getText().equals("7"))
                    totalValue += 7.0;
                else {
                    totalValue += 0.125;
                }
                updateDisplay();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button8.getText().equals("8"))
                    totalValue += 8.0;
                else {
                    totalValue += 0.11;
                }
                updateDisplay();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button9.getText().equals("9"))
                    totalValue += 9.0;
                else {
                    totalValue += 0.1;
                }
                updateDisplay();
            }
        });

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalValue = 0;
                counter = 0;
                updateDisplay();
            }
        });

        other_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("1/2");
                button2.setText("1/3");
                button3.setText("1/4");
                button4.setText("1/5");
                button5.setText("1/6");
                button6.setText("1/7");
                button7.setText("1/8");
                button8.setText("1/9");
                button9.setText("1/10");

            }
        });

        }

    private void updateDisplay() {
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        button8.setText("8");
        button9.setText("9");
        totalText.setText(String.format(Double.toString(totalValue)));
    }



}
