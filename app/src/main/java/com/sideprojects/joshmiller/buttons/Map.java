package com.sideprojects.joshmiller.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by josh on 7/20/15.
 */
public class Map {
    private int[][] solution;
    private  ColorButton[][] buttons;
    private int[][] level;
    private int size;
    private Context context;
    public Map(int size){
        this.size = size;
        solution = new int[size][size];
        buttons = new ColorButton[size][size];
        level = new int[size][size];
    }
    public void setSolutionAtPoint(int i, int j, int k){
        if(i < solution.length && j<solution.length){
            solution[i][j] = k;
        }
    }
    public void setSolution(int[][] solution){
        this.solution = solution;
    }
    public int[][] getSolution(){
        return solution;
    }
    public boolean checkWin(){
        for(int i = 0; i<solution.length; i++){
            for(int j = 0; j<solution.length; j++){
                if(!(solution[i][j] == buttons[i][j].getColor())){
                    return false;
                }
            }
        }
        System.out.println("@@@@@@@@@@@@ YOU'RE WINNER!!!!!! @@@@@@@@@@@@");
        return true;
    }
    public void makeLayout(RelativeLayout main, Context context){
        this.context = context;
        LinearLayout master = new LinearLayout(context);
        master.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        master.setWeightSum(size);
        master.setOrientation(LinearLayout.VERTICAL);
        for(int i = 0; i < size; i ++){
            LinearLayout l = new LinearLayout(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
            l.setOrientation(LinearLayout.HORIZONTAL);
            lp.weight=1;
            l.setLayoutParams(lp);
            l.setWeightSum(size);
            for(int j = 0; j < size; j++){
                LinearLayout l2 = new LinearLayout(context);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
                lp2.weight=1;
                l2.setLayoutParams(lp2);
                buttons[i][j] = new ColorButton(context, Color.BLACK);
                ColorButton b = buttons[i][j];
                b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
                b.setText("Hello!");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v instanceof  ColorButton){
                            ((ColorButton) v).toggleColor();
                            checkWin();
                        }
                    }
                });
                l2.addView(b);
                l.addView(l2);
                //buttons[i][j] = b;
            }
            master.addView(l);
        }
        int k = 0;
        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j <buttons.length; j ++){
                int color = solution[i][j];
                if(ButtonColors.isLight(color)){
                    color = ButtonColors.getToggleColor(color);
                }
                System.out.println(i + " " + j);
                buttons[i][j].setColor(color);
                buttons[i][j].setNumber(k);
                k++;
            }
        }
        main.addView(master);
    }
    public ColorButton[][] getButtons(){
        return buttons;
    }
    public ColorButton getButtonByIndex(int index){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(buttons[i][j].getNumber() == index){
                    return buttons[i][j];
                }
            }
        }
        return null;
    }
    public View getSolutionImage(){
        LinearLayout master = new LinearLayout(context);
        master.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        master.setWeightSum(size);
        master.setOrientation(LinearLayout.VERTICAL);
        for(int i = 0; i < size; i ++){
            LinearLayout l = new LinearLayout(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
            l.setOrientation(LinearLayout.HORIZONTAL);
            lp.weight=1;
            l.setLayoutParams(lp);
            l.setWeightSum(size);
            for(int j = 0; j < size; j++){
                LinearLayout l2 = new LinearLayout(context);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
                lp2.weight=1;
                l2.setLayoutParams(lp2);
                ColorButton b = new ColorButton(context, solution[i][j]);
                b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
                b.setText("Hello!");
                l2.addView(b);
                l.addView(l2);
            }
            master.addView(l);
        }
        return master;
    }
}
