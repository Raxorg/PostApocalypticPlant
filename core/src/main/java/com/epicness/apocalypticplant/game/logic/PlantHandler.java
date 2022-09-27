package com.epicness.apocalypticplant.game.logic;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.epicness.apocalypticplant.game.stuff.Segment;
import com.epicness.fundamentals.utils.Random;

import java.util.List;

public class PlantHandler extends GameLogicHandler {

    private float lastX, lastY;
    private Color lastColor;

    @Override
    protected void init() {
        float startX = CAMERA_WIDTH / 2f, startY = 0f;
        lastX = CAMERA_WIDTH / 2f;
        lastY = 100f;

        lastColor = Random.fullyRandomColor();
        Segment initialSegment = new Segment(startX, startY, lastX, lastY, Random.fullyRandomColor(), lastColor);
        List<Segment> segments = stuff.getPlant().getSegments();
        segments.clear();
        segments.add(initialSegment);
    }

    public void grow() {
        List<Segment> segments = stuff.getPlant().getSegments();
        float nextX = MathUtils.random(lastX - 100f, lastX + 100f);
        nextX = MathUtils.clamp(nextX, 10f, CAMERA_WIDTH - 10f);
        float nextY = MathUtils.random(lastY + 150f, lastY + 250f);
        Vector2 next = new Vector2(nextX, nextY);
        Color endColor = Random.fullyRandomColor();
        Segment newSegment = new Segment(lastX, lastY, next.x, next.y, lastColor, endColor);
        segments.add(newSegment);
        lastColor = endColor;
        lastX = nextX;
        lastY = nextY;
        if (newSegment.end.y >= CAMERA_HEIGHT) {
            newPlant();
        }
    }

    private void newPlant() {
        logic.handler(LivesHandler.class).addLife();
        lastX = MathUtils.random(50f, CAMERA_WIDTH - 50f);
        lastY = 0f;
    }
}