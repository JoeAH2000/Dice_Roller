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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int score = 0;
    public List<String> qlist = new ArrayList<>();

    int number;

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


    public void roll_the_dice() {

        Random r = new Random();
        number = (r.nextInt(6)+1);

    }
    public void btnLucky_Click(View view){
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView ctv = this.findViewById(R.id.congratTextView);
        TextView stv = this.findViewById(R.id.scoreTextView);
        EditText et = this.findViewById(R.id.guessText);

        String userGuess = et.getText().toString();
        int userGuessInt = Integer.parseInt(userGuess);

        roll_the_dice();

        Congratulations(tv, ctv, userGuessInt);


        stv.setText(Integer.toString(score));
    }

    public void Congratulations(TextView tv, TextView ctv, int userGuessInt) {
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
    }

    public void BtnIceBreaker_click(View view){
        TextView tv = this.findViewById(R.id.numberTextView);
        TextView ctv = this.findViewById(R.id.congratTextView);
        ctv.setText("");


        initialise();

        roll_the_dice();
        tv.setText(qlist.get(number-1));

        }

    private void initialise() {
        qlist.add("If you could go anywhere in the world, where would you go?");
        qlist.add("If you where stranded on a desert island, what three things would you want to take with you?");
        qlist.add("If you could eat only one food for the rest of your life, what would it be?");
        qlist.add("If you won a million dollars, what is the first thing you would buy?");
        qlist.add("If you could spend the day with one fictional character, who would it be?");
        qlist.add("If you found a magic lantern and a gene gave you three wishes, what would you wish?");
    }
}
