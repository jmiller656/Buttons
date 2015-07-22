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
    public static final int lOrange = Color.rgb(255,163,121);
    public static final int dOrange = Color.rgb(164, 58, 0);
    public static final int lPurple = Color.rgb(176,72,201);
    public static final int dPurple = Color.rgb(85,0,141);
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
        else if(color == lOrange){
            return dOrange;
        }
        else if(color == dOrange){
            return lOrange;
        }
        else if(color == lPurple){
            return dPurple;
        }
        else if(color == dPurple){
            return lPurple;
        }
        else{
            return 0;
        }
    }
    public static boolean isDark(int color){
        return color == dBlue || color == dGreen || color == dOrange || color == dPurple;
    }
    public static boolean isLight(int color){
        return color == lBlue || color == lGreen || color == lOrange || color == lPurple;
    }
    public static boolean isGreen(int color){
        return color == lGreen || color == dGreen;
    }
    public static boolean isBlue(int color){
        return color == lBlue  || color == dBlue;
    }
    public static boolean isOrange(int color){ return color == lOrange || color == dOrange;}
    public static boolean isPurple(int color){ return color == lPurple || color == dPurple;}
}
