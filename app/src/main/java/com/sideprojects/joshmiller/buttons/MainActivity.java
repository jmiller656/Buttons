package com.sideprojects.joshmiller.buttons;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.reflect.Array;


public class MainActivity extends Activity {
    int lBlue = Color.rgb(120,205,229);
    int dBlue = Color.rgb(29, 100, 169);
    int lGreen = Color.rgb(95, 191, 110);
    int dGreen = Color.rgb(4, 86, 50);
    int colors[] = {dGreen,dGreen,dBlue,dGreen,dBlue,dBlue,dBlue,dGreen,dGreen};
    int[][] level = new int[9][1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        for(int i = 0; i < level.length; i++){
            level[i][0] = -1;
        }
        level[2][0] = 1;
        level[4][0] = 3;
        level[5][0] = 8;
        level[6][0] = 7;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorButton buttons[] =new ColorButton[9];
        LinearLayout master = new LinearLayout(getApplicationContext());
        master.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        master.setWeightSum(Math.round(Math.sqrt(buttons.length)));
        master.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        int k=0;
        for(int i = 0; i < Math.round(Math.sqrt(buttons.length)); i ++){
            LinearLayout l = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
            l.setOrientation(LinearLayout.HORIZONTAL);
            lp.weight=1;
            l.setLayoutParams(lp);
            l.setWeightSum(Math.round(Math.sqrt(buttons.length)));
            for(int j = 0; j < Math.round(Math.sqrt(buttons.length)); j++){
                LinearLayout l2 = new LinearLayout(getApplicationContext());
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
                lp2.weight=1;
                l2.setLayoutParams(lp2);
                ColorButton b = new ColorButton(getApplicationContext(),Color.BLACK);
                b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
                b.setText("Hello!");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v instanceof  ColorButton){
                            ((ColorButton) v).toggleColor();
                        }
                    }
                });
                l2.addView(b);
                l.addView(l2);
                buttons[k] = b;
                k++;
            }
            master.addView(l);
        }
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setColor(colors[i]);
            buttons[i].setNumber(i);
            if(level[i][0] != -1){
                buttons[i].getToggleList().add(buttons[level[i][0]]);
            }
        }
        mainLayout.addView(master);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void click(View v){
        Log.i("AYY LMAO", ":alien:");
    }
}
