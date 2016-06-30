package com.zeljkopratezina.myfirstapp_seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare our variables
    private static SeekBar seek_bar;
    private static TextView text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar(); // here we call our method
    }

    public void seekbar(){

        //cast our variables
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        text_view = (TextView) findViewById(R.id.textView);
        //show in text progress and maximum
        text_view.setText("Covered: " + seek_bar.getProgress() + " / " + seek_bar.getMax());

        //now we add listener to our SeekBar
        seek_bar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int progress_value;  // variable use to store progress of SeekBar
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    progress_value = progress;
                        text_view.setText("Covered: " + progress + " / " + seek_bar.getMax());
                        //Use the Toast to show a message
                        Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar in StartTracking", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view.setText("Covered: " + progress_value + " / " + seek_bar.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar in StopTracking", Toast.LENGTH_LONG).show();
                    }
                }
        );


    }
}
