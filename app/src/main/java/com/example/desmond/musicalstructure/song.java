package com.example.desmond.musicalstructure;
public class song {
    private String mSongName;
    private String mArtistName;
    private int mimageView;
    public song(String SongName, String ArtistName, int imageView ) {
        mSongName = SongName;
        mArtistName = ArtistName;
        mimageView = imageView;
    }
    public String getSongName() {
        return mSongName;
    }
    public String getArtistName() {
        return mArtistName;
    }
    public int getImageResourceID() {
        return mimageView;
    }
}
