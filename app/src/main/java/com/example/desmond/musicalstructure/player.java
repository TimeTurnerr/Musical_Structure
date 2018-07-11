package com.example.desmond.musicalstructure;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class player extends AppCompatActivity {
    private SeekBar seekbar;
    private TextView artist, song,timePos,timeDur;
    private Handler mHandler = new Handler();
    private ImageView albumart,play;
    private Utilities utils;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        mediaPlayer = MediaPlayer.create(this, R.raw.goodlife);
        timeDur = (TextView) findViewById(R.id.timeDur);
        timePos = (TextView) findViewById(R.id.timePos);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(mediaPlayer.getDuration());
        song = (TextView) findViewById(R.id.song);
        artist = (TextView) findViewById(R.id.artist);
        albumart = (ImageView) findViewById(R.id.Alb_art);
        play = (ImageView) findViewById(R.id.play);
        utils = new Utilities();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                } else {
                    player.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mediaPlayer != null) {
                                int mCurrentPosition = mediaPlayer.getCurrentPosition();
                                seekbar.setProgress(mCurrentPosition);
                                int mediaDuration = mediaPlayer.getDuration();
                                int mediaPosition = mediaPlayer.getCurrentPosition();
                                timeDur.setText(""+utils.milliSecondsToTimer(mediaDuration));
                                timePos.setText(""+utils.milliSecondsToTimer(mediaPosition));
                            }
                            mHandler.postDelayed(this, 1000);
                        }
                    });
                    seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) { }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) { }
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            if(mediaPlayer != null && fromUser){
                                mediaPlayer.seekTo(progress);
                            }
                        }
                    });
                    song.setText("Good Life");
                    artist.setText("G-Eazy & Kehlani");
                    albumart.setImageResource(R.drawable.goodlife);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                    play.setImageResource(R.drawable.pause);
                }
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                play.setImageResource(R.drawable.play);
                mediaPlayer.seekTo(0);
                mediaPlayer.stop();
                mediaPlayer.prepareAsync();
            }
        });
        ImageView library = (ImageView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(player.this, my_music.class);
                libraryIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(libraryIntent);
            }
        });
        ImageButton go_online = (ImageButton) findViewById(R.id.go_online);
        go_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_onlineIntent = new Intent(player.this, online.class);
                go_onlineIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(go_onlineIntent);
            }
        });
    }
    public void onBackPressed() {
        Intent home = new Intent(player.this, MainActivity.class);
        home.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        startActivity(home);
    }
}
