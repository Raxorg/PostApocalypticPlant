package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.badlogic.gdx.utils.Align.center;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Text;

public class CounterHandler extends GameLogicHandler {

    private float time;
    private boolean paused, disabled;

    private void updateCounter() {
        stuff.getCounter().setText((time * 10 + "").substring(0, 2));
    }

    @Override
    protected void init() {
        time = 4f;
        paused = true;
        disabled = false;
        Text counter = stuff.getCounter();
        counter.setY(CAMERA_HEIGHT / 2f);
        updateCounter();
        counter.setTextTargetWidth(CAMERA_WIDTH);
        counter.setHorizontalAlignment(center);
        counter.setCenterVertical(true);
        counter.setColor(WHITE);
    }

    public void update(float delta) {
        if (disabled) {
            return;
        }
        if (paused) {
            return;
        }
        Text counter = stuff.getCounter();
        if (stuff.getLives().size == 0) {
            counter.setColor(CLEAR);
            return;
        }
        time -= delta;
        updateCounter();
        if (time <= 0f) {
            logic.get(LivesHandler.class).loseLife();
            time = MathUtils.random(2.8f, 3.5f);
        }
        if (time <= 1f) {
            counter.setColor(CLEAR);
        } else {
            counter.setColor(WHITE);
        }
    }

    public void touchDown() {
        if (disabled) {
            logic.get(PlantHandler.class).grow();
            return;
        }
        if (paused) {
            paused = false;
        }
        if (time >= 2f) {
            return;
        }
        if (time > 0.33f) {
            logic.get(LivesHandler.class).loseLife();
        } else {
            logic.get(PlantHandler.class).grow();
            logic.get(ScoreHandler.class).addScore();
        }
        time = MathUtils.random(2.8f, 3.5f);
    }

    public void disable() {
        disabled = true;
        stuff.getCounter().setColor(CLEAR);
    }
}