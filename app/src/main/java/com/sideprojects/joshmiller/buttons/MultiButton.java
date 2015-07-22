package com.sideprojects.joshmiller.buttons;

import android.content.Context;

/**
 * Created by josh on 7/22/15.
 */
public class MultiButton extends ColorButton{
    public ColorButton[] togglePartner;
    public MultiButton(Context context, int color){
        super(context,color);
    }
    @Override
    public void toggleColor(){
        super.toggleColor();
        for(int i = 0; i<togglePartner.length; i++){
            if(togglePartner[i]!= null){
                togglePartner[i].partnerToggle();
            }
        }
    }
    public void setPartner(ColorButton c){

        for(int i = 0; i<togglePartner.length; i++){
            if(togglePartner[i] == null){
                togglePartner[i] = c;
                return;
            }
        }

    }
}
