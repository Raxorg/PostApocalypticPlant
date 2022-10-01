package com.epicness.apocalypticplant.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.utils.Random;

public class LivesHandler extends GameLogicHandler {

    private boolean disabled;

    @Override
    protected void init() {
        disabled = false;
        DelayedRemovalArray<Sprited> lives = stuff.getLives();
        lives.clear();
        for (int i = 0; i < 3; i++) {
            addLife();
        }
    }

    public void loseLife() {
        DelayedRemovalArray<Sprited> lives = stuff.getLives();
        if (lives.size == 0) {
            return;
        }
        if (lives.size == 1) {
            logic.get(ScoreHandler.class).showFinalScore();
        }
        lives.begin();
        lives.removeIndex(lives.size - 1);
        lives.end();
    }

    public void addLife() {
        if (disabled) {
            return;
        }
        DelayedRemovalArray<Sprited> lives = stuff.getLives();
        Sprited life = new Sprited(assets.getHeart());
        life.setSize(100f);
        life.translateX(100f * lives.size);
        life.setColor(Random.fullyRandomColor());
        lives.add(life);
    }

    public void disable() {
        stuff.getLives().clear();
        disabled = true;
    }
}