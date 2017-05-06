package com.exampe.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
implements SeekBar.OnSeekBarChangeListener, TextWatcher{

    private TextView amountText;
    private EditText userInput;
    private TextView percentageText;
    private SeekBar percentageBar;
    private TextView tipText;
    private TextView totalText;

    private NumberFormat percentageFormatter = NumberFormat.getPercentInstance();
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    private Double percentageValue;
    private Double amountValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amountText = (TextView) findViewById(R.id.amountText);
        userInput = (EditText) findViewById(R.id.userInput);
        percentageText = (TextView) findViewById(R.id.percentageText);
        percentageBar = (SeekBar) findViewById(R.id.percentageBar);
        tipText = (TextView) findViewById(R.id.tipText);
        totalText = (TextView) findViewById(R.id.totalText);

        percentageBar.setOnSeekBarChangeListener(this);
        userInput.addTextChangedListener(this);
        percentageValue = 10.0;
        amountValue = 10.0;


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        percentageValue = progress /100.0;
        percentageText.setText(percentageFormatter.format(percentageValue));


        double tipValue = amountValue * percentageValue;
        double totalValue = tipValue + amountValue;

        tipText.setText(currencyFormatter.format(tipValue));
        totalText.setText(currencyFormatter.format(totalValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int before, int count) {
        if(text.length() > 0) {
            double value = Double.parseDouble(text.toString());
            amountValue = value / 100;
            amountText.setText(currencyFormatter.format(amountValue));

            double tipValue = amountValue * percentageValue;
            double totalValue = tipValue + amountValue;

            tipText.setText(currencyFormatter.format(tipValue));
            totalText.setText(currencyFormatter.format(totalValue));

        } else {

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
