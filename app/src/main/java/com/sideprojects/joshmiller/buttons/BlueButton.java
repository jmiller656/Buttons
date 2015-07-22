package com.sideprojects.joshmiller.buttons;

import android.content.Context;

/**
 * Created by josh on 7/22/15.
 */
public class BlueButton extends ColorButton{
    private ColorButton togglePartner;
    public BlueButton(Context context){
        super(context,ButtonColors.dBlue);
    }
    @Override
    public void toggleColor(){
        super.toggleColor();
        if(togglePartner!= null){
            togglePartner.toggleColor();
        }
    }
    public void setPartner(ColorButton c){
        togglePartner = c;
    }
}
