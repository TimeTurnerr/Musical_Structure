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
    private TextView artist, song;
    private Handler mHandler = new Handler();
    private ImageView albumart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.goodlife);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(mediaPlayer.getDuration());
        song = (TextView) findViewById(R.id.song);
        artist = (TextView) findViewById(R.id.artist);
        albumart = (ImageView) findViewById(R.id.Alb_art);
        final ImageView play = (ImageView) findViewById(R.id.play);
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
                                int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                                seekbar.setProgress(mCurrentPosition);
                            }
                            mHandler.postDelayed(this, 1000);
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
        ImageView library = (ImageView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(player.this, my_music.class);
                libraryIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(libraryIntent);
            }
        });
        ImageButton go_online = (ImageButton) findViewById(R.id.go_online);
        go_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_onlineIntent = new Intent(player.this, online.class);
                go_onlineIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(go_onlineIntent);
            }
        });
    }
}
