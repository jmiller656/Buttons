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
    final int lBlue = Color.rgb(120,205,229);
    final int dBlue = Color.rgb(29, 100, 169);
    final int lGreen = Color.rgb(95, 191, 110);
    final int dGreen = Color.rgb(4, 86, 50);
    private int color = 0;
    int number = 0;
    private ArrayList<Integer> toggleList = new ArrayList<Integer>();

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
        if(color==lGreen){
            setColor(dGreen);
        }
        else if(color == dGreen){
            setColor(lGreen);
        }
        else if(color == dBlue){
            setColor(lBlue);
        }
        else if(color == lBlue){
            setColor(dBlue);
        }
    }
}
