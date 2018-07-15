package com.example.desmond.musicalstructure;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyAppWebViewClient());
        mWebView.loadUrl("https://www.saavn.com/");
        LinearLayout my_music = (LinearLayout) findViewById(R.id.my_music);
        my_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my_musicIntent = new Intent(MainActivity.this, MyMusicActivity.class);
                my_musicIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(my_musicIntent);
            }
        });
        LinearLayout player = (LinearLayout) findViewById(R.id.player);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                playerIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(playerIntent);
            }
        });
        LinearLayout online = (LinearLayout) findViewById(R.id.online);
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent onlineIntent = new Intent(MainActivity.this, OnlineActivity.class);
                onlineIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP );
                startActivity(onlineIntent);
            }
        });
    }
}
