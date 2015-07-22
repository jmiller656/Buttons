package com.sideprojects.joshmiller.buttons;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by josh on 7/16/15.
 */
public class ColorButton extends Button {
    private int color = 0;
    int number = 0;

    public ColorButton(Context context, int color) {
        super(context);
        setColor(color);
    }

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        this.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        this.color = color;
    }

    public void setNumber(int i){
        this.number = i;
    }

    public int getNumber(){
        return number;
    }

    public void toggleColor(){
        setColor(ButtonColors.getToggleColor(color));
    }

}
