package com.epicness.apocalypticplant.game.logic;

public class MusicHandler extends GameLogicHandler {

    @Override
    protected void init() {
        if (!assets.getMusic().isPlaying()) {
            assets.getMusic().setLooping(true);
            assets.getMusic().setVolume(0.4f);
            assets.getMusic().play();
        }
    }
}