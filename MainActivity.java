package com.example.mycolorbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    //declare the properties to be used
    SeekBar redBar,greenBar,blueBar;
    TextView lblResult;
    //color variables
    int red,green,blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiate the properties
        redBar =findViewById(R.id.redbar);
        greenBar =findViewById(R.id.greenbar);
        blueBar =findViewById(R.id.bluebar);
        lblResult =findViewById(R.id.lblResult);
        //assigning event Listener to the seekbars
        redBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            int id = seekBar.getId();
            switch(id) {
                case R.id.redbar:
                    red=redBar.getProgress();
                    break;
                case R.id.greenbar:
                    green=greenBar.getProgress();
                    break;
                case R.id.bluebar:
                    blue=blueBar.getProgress();
            }
            lblResult.setBackgroundColor(Color.rgb(red,green,blue));
            String result=String.format("#%2X%2X%2X",red,green,blue);
            lblResult.setText(result);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}