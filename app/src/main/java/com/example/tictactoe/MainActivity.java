package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutGameboard;
    Button btnNewGame, btnReset;
    Button[][] buttons = new Button[3][3];
    Boolean playerTurn = Boolean.TRUE;
    TextView tvPointX, tvPointO;
    int xWin = 0;
    int oWin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPointX = findViewById(R.id.tvPointX);
        tvPointO = findViewById(R.id.tvPointO);
        btnNewGame = findViewById(R.id.btnNewGame);
        btnReset = findViewById(R.id.btnReset);
        layoutGameboard = findViewById(R.id.layoutGameboard);
        for (int row = 0; row < 3; row++) {
            Factory factory = new Factory(MainActivity.this);
            LinearLayout lin = factory.createLayout();
            layoutGameboard.addView(lin);
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = factory.createButton();
                buttons[row][col].setOnClickListener(this);
                buttons[row][col].setTextSize(90);
                lin.addView(buttons[row][col]);
            }
        }
        btnReset.setOnClickListener(view -> {
            finish();
            startActivity(getIntent());
        });
        btnNewGame.setOnClickListener(view -> {
            playerWin w = new playerWin(MainActivity.this);
            w.NewGame(buttons);
        });
    }

    @Override
    public void onClick(View view) {
        playerWin plWin = new playerWin(MainActivity.this);
        Button b = (Button) view;
        Boolean isClicked = b.getText().toString().length() == 0;
        if (isClicked) {
            String karakter = playerTurn ? "X" : "O";
            playerTurn = !playerTurn;
            b.setText(karakter);
            String win = plWin.CheckWin(buttons);
            if (win == "X") {
                xWin += 1;
                tvPointX.setText("" + xWin);
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        buttons[row][col].setEnabled(false);
                    }
                }
            }
            if (win == "O") {
                oWin += 1;
                tvPointO.setText("" + oWin);
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        buttons[row][col].setEnabled(false);
                    }
                }
            }
        }
    }
}