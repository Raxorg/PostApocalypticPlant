package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.RED;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class OverlayHandler extends GameLogicHandler {

    private float time;
    private boolean showing;

    @Override
    protected void init() {
        stuff.getOverlay().setColor(CLEAR);
    }

    public void show() {
        stuff.getOverlay().setColor(RED.cpy().lerp(BLACK, 0.5f));
        showing = true;
        time = 0f;
    }

    public void update(float delta) {
        if (!showing) {
            return;
        }
        time += delta;
        if (time > 0.25f) {
            time = 0.25f;
            showing = false;
        }
        Color color = stuff.getOverlay().getColor();
        color.a = MathUtils.map(0, 0.25f, 1f, 0f, time);
        stuff.getOverlay().setColor(color);
    }
}