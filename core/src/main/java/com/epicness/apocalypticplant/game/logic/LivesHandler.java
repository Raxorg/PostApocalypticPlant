package com.epicness.apocalypticplant.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;

public class LivesHandler extends GameLogicHandler {

    @Override
    protected void init() {
        DelayedRemovalArray<Sprited> lives = stuff.getLives();
        lives.clear();
        for (int i = 0; i < 3; i++) {
            Sprited life = new Sprited(assets.getHeart());
            life.setSize(100f);
            life.translateX(100f * i);
            lives.add(life);
        }
    }

    public void loseLife() {
        DelayedRemovalArray<Sprited> lives = stuff.getLives();
        if (lives.size == 0) {
            return;
        }
        if (lives.size == 1) {
            logic.handler(ScoreHandler.class).showFinalScore();
        }
        lives.begin();
        lives.removeIndex(lives.size - 1);
        lives.end();
    }
}