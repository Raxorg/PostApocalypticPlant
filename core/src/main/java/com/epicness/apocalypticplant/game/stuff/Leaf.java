package com.epicness.apocalypticplant.game.stuff;

import static com.epicness.apocalypticplant.game.GameConstants.LEAF_GLOW_HEIGHT;
import static com.epicness.apocalypticplant.game.GameConstants.LEAF_GLOW_WIDTH;
import static com.epicness.apocalypticplant.game.GameConstants.LEAF_HEIGHT;
import static com.epicness.apocalypticplant.game.GameConstants.LEAF_WIDTH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.DualSprited;

public class Leaf extends DualSprited {

    public Leaf(Sprite leafBaseSprite, Sprite leafGlowSprite) {
        super(leafGlowSprite, leafBaseSprite);
        setBackgroundSize(LEAF_GLOW_WIDTH, LEAF_GLOW_HEIGHT);
        setForegroundSize(LEAF_WIDTH, LEAF_HEIGHT);
        centerBackgroundOnForeground();
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        centerBackgroundOnForeground();
    }
}