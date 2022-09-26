package com.epicness.apocalypticplant.game.logic;

import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.epicness.apocalypticplant.game.stuff.Segment;

import java.util.List;

public class PlantHandler extends GameLogicHandler {

    // Logic
    private float time;

    @Override
    protected void init() {
        float x1 = CAMERA_WIDTH / 2f, y1 = 0f;
        float x2 = CAMERA_WIDTH / 2f, y2 = 100f;
        Segment initialSegment = new Segment(x1, y1, x2, y2);
        List<Segment> segments = stuff.getPlant().getSegments();
        segments.clear();
        segments.add(initialSegment);
    }

    public void update(float delta) {
        time += delta;
        if (time >= 5f) {
            grow();
            time = 0f;
        }
    }

    public void grow() {
        List<Segment> segments = stuff.getPlant().getSegments();
        segments.add(new Segment(0f, 0f, 100f, 100f));
    }
}