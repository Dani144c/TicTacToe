package com.example.tictactoe;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;

public class Factory {
    Context ctx;

    public Factory(Context ctx) {
        this.ctx = ctx;
    }

    public Button createButton() {
        Button btn = new Button(ctx);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        btnParams.weight = 1;
        btn.setLayoutParams(btnParams);
        return btn;
    }

    public LinearLayout createLayout() {
        LinearLayout lin = new LinearLayout(ctx);
        LinearLayout.LayoutParams linParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linParams.weight = 1;
        lin.setLayoutParams(linParams);
        lin.setWeightSum(3);
        lin.setOrientation(LinearLayout.HORIZONTAL);

        return lin;
    }
}
