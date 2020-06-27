package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



//Buttons
public class MainActivity extends AppCompatActivity {
    int[] ids = {R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6,
            R.id.button_7, R.id.button_8, R.id.button_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Restart Game

            Button restartGame = (Button) findViewById(R.id.Restart);
            restartGame.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                for (int i = 0; i < ids.length; i++) {

                    ((Button)   findViewById( ids[i])).setText("");
                }
                    ((TextView)   findViewById(R.id.textview_first)).setText("Welcome To TicTacToe");
                    xIsNext = true;
            }});


        for (int i = 0; i < ids.length; i++) {

            final int finalI = i;
            findViewById(ids[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleClick(finalI);
                }
            });
        }

    }


    //X or O
    boolean xIsNext = true;

    void handleClick(int i) {
        Toast.makeText(getApplicationContext(), "Clicked" + i, Toast.LENGTH_SHORT).show();

        //Overlapping
        Button button = (Button) findViewById(ids[i]);
        if (button.getText().equals("x") || button.getText().equals("o")){
            return;
        }
        if (xIsNext) {
            button.setText("x");

        } else {
            button.setText("o");
        }
        xIsNext = !xIsNext;







        //Checking Winner
        checkWinner();
    }

    void checkWinner() {
        int[][] solutions = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}

        };

        //Solutions
        for (int i = 0; i < solutions.length; i++) {
            int[] solution = solutions[i];


            Button buttonA = (Button) findViewById(ids[solution[0]]);
            Button buttonB = (Button) findViewById(ids[solution[1]]);
            Button buttonC = (Button) findViewById(ids[solution[2]]);


            if (buttonA.getText().equals(buttonB.getText()) && buttonB.getText().equals(buttonC.getText()) && !buttonA.getText().equals("")) {
                ( (TextView)findViewById(R.id.textview_first) ).setText(buttonA.getText()+" is Winner");
            }


        }
    }
}