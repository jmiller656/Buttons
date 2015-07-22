package com.sideprojects.joshmiller.buttons;

/**
 * Created by josh on 7/22/15.
 */
public class PartnerList {
    private int index;
    private int[] partners;
    public PartnerList(int index, int[] partners){
        this.index = index;
        this.partners = partners;
    }
    public int getIndex(){
        return index;
    }
    public int[] getPartners(){
        return partners;
    }
}
