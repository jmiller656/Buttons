package com.sideprojects.joshmiller.buttons;

import android.graphics.Color;

/**
 * Created by josh on 7/20/15.
 */
public class ButtonColors {
    public static final int lBlue = Color.rgb(120, 205, 229);
    public static final int dBlue = Color.rgb(29, 100, 169);
    public static final int lGreen = Color.rgb(95, 191, 110);
    public static final int dGreen = Color.rgb(4, 86, 50);
    public static int getToggleColor(int color){
        if(color == lBlue){
            return dBlue;
        }
        else if(color == dBlue){
            return lBlue;
        }
        else if(color == dGreen){
            return lGreen;
        }
        else if(color == lGreen){
            return dGreen;
        }
        else{
            return 666;
        }
    }
    public static boolean isDark(int color){
        return color == dBlue || color == dGreen;
    }
    public static boolean isLight(int color){
        return color == lBlue || color == lGreen;
    }
}
