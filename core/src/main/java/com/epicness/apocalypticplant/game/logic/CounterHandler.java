package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Text;

public class CounterHandler extends GameLogicHandler {

    private float time;

    @Override
    protected void init() {
        stuff.getCounter().setPosition(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f);
        stuff.getCounter().setText("5f");
        time = 5f;
    }

    public void update(float delta) {
        if (stuff.getLives().size == 0) {
            return;
        }
        time -= delta;
        Text counter = stuff.getCounter();
        counter.setText(String.format("%.1f", time));
        if (time <= 0f) {
            logic.handler(LivesHandler.class).loseLife();
            time = MathUtils.random(2.8f, 3.5f);
        }
        if (time <= 1f) {
            counter.setColor(CLEAR);
        } else {
            counter.setColor(WHITE);
        }
    }

    public void touchDown() {
        if (time >= 2f) {
            return;
        }
        if (time > 0.3f) {
            logic.handler(LivesHandler.class).loseLife();
        } else {
            logic.handler(ScoreHandler.class).addScore();
        }
        time = MathUtils.random(2.8f, 3.5f);
    }
}