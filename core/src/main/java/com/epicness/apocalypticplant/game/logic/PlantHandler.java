package com.epicness.apocalypticplant.game.logic;

import static com.epicness.apocalypticplant.game.GameConstants.LEAF_HEIGHT;
import static com.epicness.apocalypticplant.game.GameConstants.LEAF_ORIGIN_X;
import static com.epicness.apocalypticplant.game.GameConstants.LEAF_ORIGIN_Y;
import static com.epicness.apocalypticplant.game.GameConstants.LEAF_WIDTH;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.apocalypticplant.game.stuff.Segment;
import com.epicness.fundamentals.stuff.DualSprited;
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

        DelayedRemovalArray<DualSprited> leaves = stuff.getLeaves();
        leaves.begin();
        leaves.clear();
        spawnLeaf(initialSegment, 1f, 90f, lastColor);
        leaves.end();
    }

    public void grow() {
        List<Segment> segments = stuff.getPlant().getSegments();
        float nextX = MathUtils.random(lastX - 125f, lastX + 125f);
        nextX = MathUtils.clamp(nextX, 30f, CAMERA_WIDTH - 30f);
        float nextY = MathUtils.random(lastY + 150f, lastY + 240f);
        Vector2 next = new Vector2(nextX, nextY);
        Color endColor = Random.fullyRandomColor();
        Segment newSegment = new Segment(lastX, lastY, next.x, next.y, lastColor, endColor);
        segments.add(newSegment);

        if (MathUtils.randomBoolean()) {
            float extraAngle = MathUtils.randomBoolean() ? 45f : -45f;
            Vector2 extra = next.cpy().rotateAroundDeg(new Vector2(lastX, lastY), extraAngle);
            Segment extraSegment = new Segment(lastX, lastY, extra.x, extra.y, lastColor, endColor);
            spawnLeaves(extraSegment);
            segments.add(extraSegment);
        }

        lastColor = endColor;
        lastX = nextX;
        lastY = nextY;
        spawnLeaves(newSegment);
        Array<Vector2> path = newSegment.path;
        if (path.get(path.size - 1).y >= CAMERA_HEIGHT - 50f) {
            newPlant();
        }
        assets.getLeafSound().play();
    }

    private void spawnLeaf(Segment segment, float segmentPortion, float angle, Color color) {
        int pointIndex = (int) MathUtils.map(0f, 1f, 0, segment.path.size - 1, segmentPortion);
        Vector2 segmentPoint = segment.path.get(pointIndex);
        DualSprited leaf = new DualSprited(assets.getLeaf(), assets.getLeafGlow());
        leaf.setSize(LEAF_WIDTH, LEAF_HEIGHT);
        leaf.setOrigin(LEAF_ORIGIN_X, LEAF_ORIGIN_Y);
        leaf.rotate(angle);
        leaf.setOriginBasedPosition(segmentPoint.x, segmentPoint.y);
        leaf.setColor(color);
        leaf.setScale(MathUtils.random(0.5f, 1f));
        stuff.getLeaves().add(leaf);
    }

    private void spawnLeaves(Segment segment) {
        int leaves = MathUtils.random(1, 2);
        for (int i = 0; i < leaves; i++) {
            float portion = MathUtils.random(0.2f, 0.8f);
            float angle = MathUtils.random(-40f, 220f);
            Color color = segment.color1.cpy().lerp(segment.color2, portion);
            spawnLeaf(segment, portion, angle, color);
        }
        spawnLeaf(segment, 1f, MathUtils.random(0f, 180f), segment.color2);
    }

    private void newPlant() {
        logic.handler(LivesHandler.class).addLife();
        lastX = MathUtils.random(50f, CAMERA_WIDTH - 50f);
        lastY = 0f;
    }
}