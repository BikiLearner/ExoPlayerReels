package com.example.exoplayerassignment;

import androidx.media3.exoplayer.ExoPlayer;

public class ExoplayerItem {
    private ExoPlayer exoPlayer;

    public ExoPlayer getExoPlayer() {
        return exoPlayer;
    }

    public void setExoPlayer(ExoPlayer exoPlayer) {
        this.exoPlayer = exoPlayer;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    public ExoplayerItem(ExoPlayer exoPlayer, int position) {
        this.exoPlayer = exoPlayer;
        this.position = position;
    }
}
