package com.epicness.apocalypticplant.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.utils.Random;

public class Segment {

    public final Vector2 start, end;
    public final Color color1, color2;

    public Segment(float x1, float y1, float x2, float y2) {
        start = new Vector2(x1, y1);
        end = new Vector2(x2, y2);
        color1 = Random.randomColor();
        color2 = Random.exclusiveRandomColor(color1);
    }
}