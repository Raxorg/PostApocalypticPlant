package com.epicness.apocalypticplant.game.stuff;

import static com.epicness.apocalypticplant.game.GameConstants.PLANT_RADIUS;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class Segment {

    public final Array<Vector2> path;
    public final Color color1, color2;

    public Segment(float x1, float y1, float x2, float y2, Color startColor, Color endColor, float curving) {
        Vector2 start = new Vector2(x1, y1);
        Vector2 end = new Vector2(x2, y2);
        Vector2 curver = start.cpy().lerp(end, 0.5f);
        curver.x += curving;
        Bezier<Vector2> curve = new Bezier<>(start, curver, end);

        path = new Array<>();
        int points = (int) (start.dst(end) / 10f);
        for (int i = 0; i <= points; i++) {
            float t = MathUtils.map(0, points, 0f, 1f, i);
            path.add(curve.valueAt(new Vector2(), t));
        }

        color1 = startColor;
        color2 = endColor;
    }

    public void draw(ShapeDrawer shapeDrawer) {
        for (int i = 0; i < path.size; i++) {
            float progress = i / (path.size - 1f);
            shapeDrawer.filledCircle(path.get(i), PLANT_RADIUS, color1.cpy().lerp(color2, progress));
        }
    }
}