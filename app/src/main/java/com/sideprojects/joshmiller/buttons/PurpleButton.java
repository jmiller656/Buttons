package com.sideprojects.joshmiller.buttons;

import android.content.Context;

/**
 * Created by josh on 7/22/15.
 */
public class PurpleButton extends MultiButton {
    public PurpleButton(Context context){
        super(context,ButtonColors.dPurple);
        this.togglePartner = new ColorButton[3];
    }
}
