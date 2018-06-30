package com.example.desmond.musicalstructure;

public class song {

    private String mSongName;

    private String mArtistName;

    public song(String SongName, String ArtistName) {
        mSongName = SongName;
        mArtistName = ArtistName;
    }

    public String getmSongName() {
        return mSongName;
    }


    public String getmArtistName() {
        return mArtistName;
    }
}
