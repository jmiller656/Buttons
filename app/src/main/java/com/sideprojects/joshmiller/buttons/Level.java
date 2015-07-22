package com.sideprojects.joshmiller.buttons;

import java.util.ArrayList;

/**
 * Created by josh on 7/20/15.
 */
public class Level {
    private int[][] solution;
    private PartnerList[] partners;
    private int size;
    public Level(int[][] solution, PartnerList[] partners){
        this.size = solution.length;
        this.solution = solution;
        this.partners = partners;
    }
    public int getSize(){
        return size;
    }
    public int[][] getSolution(){
        return solution;
    }
    public PartnerList[] getPartners(){
        return partners;
    }
}
