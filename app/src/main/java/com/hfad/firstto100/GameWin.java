package com.hfad.firstto100;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import  java.util.Random;

public class GameWin extends AppCompatActivity {
int sum,input;
TextView text,winner;
String val;
Handler handler;
Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);
        sum = 0;
        text = findViewById(R.id.txt);
        winner = findViewById(R.id.winner);
        handler = new Handler();
        r = new Random();
    }

    @Override
    public void onStart()
    {
        super.onStart();

    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id._1: input = 1; break;
            case R.id._2: input = 2; break;
            case R.id._3: input = 3; break;
            case R.id._4: input = 4; break;
            case R.id._5: input = 5; break;
            case R.id._6: input = 6; break;
            case R.id._7: input = 7; break;
            case R.id._8: input = 8; break;
            case R.id._9: input = 9; break;
            case R.id._10: input =10;

        }

        sum += input;
        text.setText(String.valueOf(sum));
        text.setBackgroundColor(Color.YELLOW);
        if(sum == 100)
        winner.setText("You Won");
      handler.postDelayed(new Runnable()

                          {
                              public void run()
                              {
                                  sum += no(sum);
                                  if(sum == 100)
                                      winner.setText("You Lost");
                                  text.setText(String.valueOf(sum));
                                  text.setBackgroundColor(Color.WHITE);
                              }

                          }
      ,1500);


    }


    int no(int s)
    {
        int NotoVictory = ((s/10)*11 + 1 ) - s;

        if( NotoVictory > 0)
            return NotoVictory;
        else
            NotoVictory = (((s/10) + 1)*11 + 1) - s;

        if( NotoVictory <= 10)
            return NotoVictory;

        return (r.nextInt(9) + 1);
    }
}
