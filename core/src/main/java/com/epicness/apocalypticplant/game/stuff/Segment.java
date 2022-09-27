package com.epicness.apocalypticplant.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Segment {

    public final Vector2 start, end;
    public final Color color1, color2;

    public Segment(float x1, float y1, float x2, float y2, Color startColor, Color endColor) {
        start = new Vector2(x1, y1);
        end = new Vector2(x2, y2);
        color1 = startColor;
        color2 = endColor;
    }
}