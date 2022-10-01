package com.epicness.apocalypticplant.game.stuff;

import java.util.ArrayList;
import java.util.List;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Plant {

    private final List<Segment> segments;

    public Plant() {
        segments = new ArrayList<>();
    }

    public void draw(ShapeDrawer shapeDrawer) {
        for (int i = 0; i < segments.size(); i++) {
            segments.get(i).draw(shapeDrawer);
        }
    }

    public List<Segment> getSegments() {
        return segments;
    }
}