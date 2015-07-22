package com.sideprojects.joshmiller.buttons;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;


public class MainActivity extends Activity {
    private RelativeLayout mainLayout;
    private Map m;
    private MasterHandler handler;
    private int level = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        this.handler = new MasterHandler(this);
        drawLevel();
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
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this).
                            setMessage("Solution").
                            setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).
                            setView(m.getSolutionImage());
            builder.create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void drawLevel(){
        m = new Map(GlobalLevels.levels[level].getSize());
        m.setHandler(handler);
        m.setSolution(GlobalLevels.levels[level].getSolution());
        m.makeLayout(mainLayout, getApplicationContext());
        if(GlobalLevels.levels[level].getPartners()!= null){
            for(int i = 0; i < GlobalLevels.levels[level].getPartners().length; i++){
                ColorButton b = m.getButtonByIndex(GlobalLevels.levels[level].getPartners()[i].getIndex());
                if(b!= null){
                    for(int j = 0; j < GlobalLevels.levels[level].getPartners()[i].getPartners().length;j++){
                        ColorButton partner = m.getButtonByIndex(GlobalLevels.levels[level].getPartners()[i].getPartners()[j]);
                        if(b instanceof BlueButton){
                            ((BlueButton) b).setPartner(partner);
                        }
                        else if(b instanceof OrangeButton){
                            ((OrangeButton) b).setPartner(partner);
                        }
                        else if(b instanceof PurpleButton){
                            ((PurpleButton) b).setPartner(partner);
                        }
                    }
                }
            }
        }
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setMessage("Solution").
                        setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setView(m.getSolutionImage());
        builder.create().show();
    }

    public void advanceLevel(){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setMessage("You win!").
                        setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if(level+1<GlobalLevels.levels.length){
                                    level+=1;
                                    drawLevel();
                                }
                                else{
                                    mainLayout.removeAllViews();
                                    ColorButton b = new ColorButton(getApplicationContext(),ButtonColors.lPurple);
                                    b.setText("Restart");
                                    b.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            level = 0;
                                            drawLevel();
                                        }
                                    });
                                    mainLayout.addView(b);
                                }
                            }
                        });
        builder.create().show();
    }
    public class MasterHandler extends Handler {
        private final WeakReference<MainActivity> activity;
        public MasterHandler(MainActivity activity){
            this.activity = new WeakReference<MainActivity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {

            MainActivity a = activity.get();
            if(a!= null){
                switch (msg.what){
                    case 106:
                        a.advanceLevel();
                        break;
                }
            }
        }
    }
}
