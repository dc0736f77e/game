package com.example.victorbeil.myapplication2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.victorbeil.myapplication2.util.Calculator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Animation rotate;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        player = MediaPlayer.create(this, R.raw.bikering);

       Configurenextbutton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        EditText etZaehler = findViewById(R.id.nominator);
        EditText etNenner = findViewById(R.id.dominator);
        String sz = etZaehler.getText().toString();
        String sn = etNenner.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.alert));
        AlertDialog dialog = builder.create();
        if (sz.length() == 0 || sn.length() == 0) {
            dialog.show();
            return;
        }
        int z = Integer.parseInt(sz);
        int n = Integer.parseInt(sn);
        if (z*n != 0) {
            int rest;
            int ggt = Math.abs(z);
            int divisor = Math.abs(n);
            do {
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            } while (rest > 0);
            z /= ggt;
            n /= ggt;
            etZaehler.setText(Integer.toString(z));
            etNenner.setText(Integer.toString(n));
            v.startAnimation(rotate);
            player.start();
        }

        Calculator.calculate(z, n);
    }


    private void Configurenextbutton(){
        Button  nextbutton = (Button) findViewById(R.id.nextbutton);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,optionActivity.class));
            }
        });
    }


}
