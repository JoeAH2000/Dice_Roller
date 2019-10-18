package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
    public int score = 0;

    public void on_button_click(View view){

        TextView tv = this.findViewById(R.id.numberTextView);
        TextView ctv = this.findViewById(R.id.congratTextView);
        TextView stv = this.findViewById(R.id.scoreTextView);
        EditText et = this.findViewById(R.id.guessText);
        String userGuess = et.getText().toString();
        int userGuessInt = Integer.parseInt(userGuess);

        Random r = new Random();
        int number = r.nextInt(6);

        try {
            tv.setText(Integer.toString(number));
            if(userGuessInt == number){
                ctv.setText("Congrats");
                score = score + 1;
            }
            else {
                ctv.setText("Wrong!");
            }
        } catch (Exception ex){
            tv.setText(ex.toString());
        }
        stv.setText(Integer.toString(score));
    }
}
