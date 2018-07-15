package com.example.desmond.musicalstructure;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class SongAdapter extends ArrayAdapter<song> {
    public SongAdapter(Activity context, ArrayList<song> songs) {
        super(context, 0, songs);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_song, parent, false);
        }
        song currentSong = getItem(position);
        TextView song_name = (TextView) convertView.findViewById(R.id.song_name);
        song_name.setText(currentSong.getSongName());
        TextView artist_name = (TextView) convertView.findViewById(R.id.artist_name);
        artist_name.setText(currentSong.getArtistName());
        ImageView iconView = (ImageView) convertView.findViewById(R.id.Album_art);
        iconView.setImageResource(currentSong.getImageResourceID());
        return convertView;
    }
}
