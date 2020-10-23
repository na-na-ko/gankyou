package com.example.HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RPS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_p_s);
        final TextView text = findViewById(R.id.text);
        final TextView subtext = findViewById(R.id.subtext);
        Button rock = (Button)findViewById(R.id.rock);
        Button scissors = (Button)findViewById(R.id.scissors);
        Button paper = (Button)findViewById(R.id.paper);

        //opponentHand 1  "rock"
        //opponentHand 2  "scissors"
        //opponentHand 3  "paper"
        rock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(1, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(2, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(3, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(RPS.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    String changeTextOpponentHand(int hand) {
        String handText = "";
        if (hand == 1) handText = "グー";
        else if (hand == 2) handText = "チョキ";
        else if (hand == 3) handText = "パー";
        return handText;
    }
    int decideOpponentHand() {
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }
    void decideGame(int playerHand, int opponentHand, TextView subtext) {
        String decision;
        if(playerHand == opponentHand) decision = "あいこ";
        else if((playerHand == 3 && opponentHand == 1) || (playerHand+1 == opponentHand)) decision = "勝ち";
        else decision = "負け";
        subtext.setText(decision);
    }
}