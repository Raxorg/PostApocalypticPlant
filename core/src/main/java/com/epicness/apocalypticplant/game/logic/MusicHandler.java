package com.epicness.apocalypticplant.game.logic;

public class MusicHandler extends GameLogicHandler {

    public void playMusic() {
        if (!assets.getMusic().isPlaying()) {
            assets.getMusic().setLooping(true);
            assets.getMusic().setVolume(0.375f);
            assets.getMusic().play();
        }
    }
}