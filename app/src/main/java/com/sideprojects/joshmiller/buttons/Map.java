package com.sideprojects.joshmiller.buttons;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
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
    private Handler handler;
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
    public void setHandler(Handler handler){
        this.handler = handler;
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
        Message msg = Message.obtain();
        msg.what = 106;
        if(handler!= null)
            handler.sendMessage(msg);
        else{
            System.out.println("Null handler");
        }
        return true;
    }
    public void makeLayout(RelativeLayout main, Context context){
        main.removeAllViews();
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
                if(ButtonColors.isGreen(solution[i][j]))
                    buttons[i][j] = new GreenButton(context);
                else if(ButtonColors.isBlue(solution[i][j]))
                    buttons[i][j] = new BlueButton(context);
                else if(ButtonColors.isOrange(solution[i][j]))
                    buttons[i][j] = new OrangeButton(context);
                else if(ButtonColors.isPurple(solution[i][j]))
                    buttons[i][j] = new PurpleButton(context);
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
            }
            master.addView(l);
        }
        int k = 0;
        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j <buttons.length; j ++){
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
