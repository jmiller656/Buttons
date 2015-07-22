package com.sideprojects.joshmiller.buttons;

import android.content.Context;

/**
 * Created by josh on 7/22/15.
 */
public class OrangeButton extends MultiButton {
    public OrangeButton(Context context){
        super(context, ButtonColors.dOrange);
        this.togglePartner = new ColorButton[2];
    }
}
