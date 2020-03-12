package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 = x, 1 = o
    int activePlayer = 0;
    boolean gameIsActive = true;
    // 2 unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playAgain(View view)
    {
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        gameIsActive = true;
        activePlayer = 0;
        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
        LinearLayout linearLayout = findViewById(R.id.linear0);
        linearLayout.setVisibility(View.INVISIBLE);
    }


    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        // get the current Image View (counter tag)
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.lab4_x);

                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.lab4_zero);
                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = "Player1 -> 0";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Player2 -> x";

                    }
//                    Toast toast = Toast.makeText(MainActivity.this, winner + " has won", Toast.LENGTH_SHORT);
//                    toast.show();
                    MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.win);
                    ring.start();
                    TextView txt = findViewById(R.id.txt1);
                    txt.setText(winner + " has won");
                    LinearLayout lin = findViewById(R.id.linear0);
                    lin.setVisibility(View.VISIBLE);
                } else {
                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        TextView txt = findViewById(R.id.txt1);
                        txt.setText("Draw");
                        LinearLayout lin = findViewById(R.id.linear0);
                        lin.setVisibility(View.VISIBLE);
                        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.draw);
                        ring.start();
                    }
                }
            }
        }
    }

}
