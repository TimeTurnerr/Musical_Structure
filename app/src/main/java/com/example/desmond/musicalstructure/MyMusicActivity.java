package com.example.desmond.musicalstructure;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
public class MyMusicActivity extends AppCompatActivity {
    ArrayList<song> songs = new ArrayList<song>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        songs.add(new song("Good Life", "G-Eazy & Kehlani", R.drawable.goodlife));
        songs.add(new song("Song 2", "Artist 2", R.mipmap.ic_launcher));
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        LinearLayout now_playing = (LinearLayout) findViewById(R.id.Now_playing);
        now_playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my_musicIntent = new Intent(MyMusicActivity.this, PlayerActivity.class);
                my_musicIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(my_musicIntent);
            }
        });
    }
}


