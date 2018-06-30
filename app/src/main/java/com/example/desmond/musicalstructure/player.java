package com.example.desmond.musicalstructure;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class player extends AppCompatActivity {
    private Handler myHandler = new Handler();;
    private SeekBar seekbar;
    private TextView artist,song,starttime,stoptime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.demo);
        seekbar = (SeekBar)findViewById(R.id.seekBar);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        song = (TextView)findViewById(R.id.song);
        song.setText("Song.mp3");

        final ImageView play = (ImageView) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play_button);
                } else
                    {
                        mediaPlayer.start();
                        Toast.makeText(getApplicationContext(), "Playing sound",Toast.LENGTH_SHORT).show();
                        play.setImageResource(R.drawable.pause);
                    }
            }
        });

    }
}
