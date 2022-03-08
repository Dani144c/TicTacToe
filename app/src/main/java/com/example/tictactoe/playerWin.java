package com.example.tictactoe;

import android.content.Context;
import android.widget.Button;

public class playerWin {
    Context ctx;

    public playerWin(Context ctx) {
        this.ctx = ctx;
    }

    public String CheckWin(Button[][] buttons) {
        String chWin = "";
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().toString().length() == 1 &&
                    (buttons[row][1].getText().toString().length() == 1 && buttons[row][1].getText().toString() == buttons[row][0].getText().toString()) &&
                    (buttons[row][2].getText().toString().length() == 1 && buttons[row][2].getText().toString() == buttons[row][0].getText().toString())) {
                if (buttons[row][0].getText().toString() == "X"){
                    chWin = "X";
                }
                if (buttons[row][0].getText().toString() == "O"){
                    chWin = "O";
                }
            }
        }
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getText().toString().length() == 1 &&
                    (buttons[1][col].getText().toString().length() == 1 && buttons[1][col].getText().toString() == buttons[0][col].getText().toString()) &&
                    (buttons[2][col].getText().toString().length() == 1 && buttons[2][col].getText().toString() == buttons[0][col].getText().toString())) {
                if (buttons[0][col].getText().toString() == "X"){
                    chWin = "X";
                }
                if (buttons[0][col].getText().toString() == "O"){
                    chWin = "O";
                }
            }
        }
        if (buttons[0][0].getText().toString().length() == 1 &&
                (buttons[1][1].getText().toString().length() == 1 && buttons[1][1].getText().toString() == buttons[0][0].getText().toString()) &&
                (buttons[2][2].getText().toString().length() == 1 && buttons[2][2].getText().toString() == buttons[0][0].getText().toString())) {
            if (buttons[0][0].getText().toString() == "X"){
                chWin = "X";
            }
            if (buttons[0][0].getText().toString() == "O"){
                chWin = "O";
            }
        }
        if (buttons[0][2].getText().toString().length() == 1 &&
                (buttons[1][1].getText().toString().length() == 1 && buttons[1][1].getText().toString() == buttons[0][2].getText().toString()) &&
                (buttons[2][0].getText().toString().length() == 1 && buttons[2][0].getText().toString() == buttons[0][2].getText().toString())) {
            if (buttons[0][2].getText().toString() == "X"){
                chWin = "X";
            }
            if (buttons[0][2].getText().toString() == "O"){
                chWin = "O";
            }
        }
        return chWin;
    }
    public void NewGame(Button[][] buttons) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(true);
                buttons[row][col].setText("");
            }
        }
    }
}
