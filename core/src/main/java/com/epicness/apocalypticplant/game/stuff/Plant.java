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
            Segment segment = segments.get(i);
            shapeDrawer.line(segment.start, segment.end, segment.color1, segment.color2);
        }
    }

    public List<Segment> getSegments() {
        return segments;
    }
}