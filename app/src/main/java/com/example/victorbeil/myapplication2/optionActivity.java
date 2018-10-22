package com.example.victorbeil.myapplication2;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class optionActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText candidate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(this);
        candidate = findViewById(R.id.candidate);
        result = findViewById(R.id.result);
        configurebackButton();
    }

    private void configurebackButton(){
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View arg0){
        boolean df = false;
        long cand, i, mdc;

        String s = candidate.getText().toString();
        if (s.length() == 0)
            return;

        cand = Long.parseLong(s);
        mdc = (int) Math.sqrt(cand);
        for (i = 2; i <= mdc; i++)
            if (cand % i == 0){
            df = true;
            break;
        }
        if (cand <= 1) {
            result.setText(s + " "+ getString(R.string.falseArgument));
        } else {
            if (df)
                result.setText(s + " " + getString(R.string.noPrime) + "\n(" + getString(R.string.divisor) + Long.toString(i));
            else
                result.setText(s + " " + getString(R.string.prime));
        }
    }
}
