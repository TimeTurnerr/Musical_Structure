package com.example.desmond.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout my_music = (LinearLayout) findViewById(R.id.my_music);
        my_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my_musicIntent = new Intent(MainActivity.this, my_music.class);
                startActivity(my_musicIntent);
            }
        });

        LinearLayout player = (LinearLayout) findViewById(R.id.player);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playerIntent = new Intent(MainActivity.this, player.class);
                startActivity(playerIntent);
            }
        });

        LinearLayout online = (LinearLayout) findViewById(R.id.online);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent onlineIntent = new Intent(MainActivity.this, online.class);
                startActivity(onlineIntent);
            }
        });
    }
}
