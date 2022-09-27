package com.epicness.apocalypticplant.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.fundamentals.utils.Random;
import com.epicness.fundamentals.utils.TextUtils;

public class Fish extends DualSprited {

    private final Text text;
    public final float speed;

    public Fish(Sprite glowSprite, Sprite fishSprite, BitmapFont font) {
        super(glowSprite, fishSprite);
        text = new Text(font);
        text.setText(MathUtils.randomBoolean(0.05f) ? "I am wiggling I swear" : "");
        text.setTextTargetWidth(500f);
        speed = MathUtils.random(75f, 400f);
        Color color = Random.fullyRandomColor();
        setColor(color);
        text.setColor(color);
        float scale = MathUtils.random(0.25f, 0.75f);
        setSize(400f * scale, 200f * scale);
        text.setX(-TextUtils.getTextWidth(text) / 2f + getBackgroundWidth() / 2f);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        text.draw(spriteBatch);
    }

    @Override
    public void translateX(float amount) {
        super.translateX(amount);
        text.translateX(amount);
    }

    @Override
    public void translateY(float amount) {
        super.translateY(amount);
        text.translateY(amount);
    }
}