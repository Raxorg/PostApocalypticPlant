package com.epicness.apocalypticplant.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

public class Leaf {

    private final Sprited leafBase, leafGlow;

    public Leaf(Sprite leafBaseSprite, Sprite leafGlowSprite) {
        leafBase = new Sprited(leafBaseSprite);
        leafGlow = new Sprited(leafGlowSprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        leafBase.draw(spriteBatch);
        leafGlow.draw(spriteBatch);
    }

    public void setColor(Color color) {
        leafBase.setColor(color);
        leafGlow.setColor(color);
    }
}