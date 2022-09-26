package com.epicness.fundamentals.stuff;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpritedAnimation {

    private final Animation<Sprited> animation;
    private float time;

    public SpritedAnimation(Sprite[] spriteFrames, float frameDuration) {
        Sprited[] animationFrames = new Sprited[spriteFrames.length];
        for (int i = 0; i < spriteFrames.length; i++) {
            animationFrames[i] = new Sprited(spriteFrames[i]);
        }
        animation = new Animation<>(frameDuration, animationFrames);
    }

    public void draw(SpriteBatch spriteBatch) {
        animation.getKeyFrame(time).draw(spriteBatch);
    }

    public void addTime(float seconds) {
        time += seconds;
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setPosition(x, y);
        }
    }

    public void setSize(float size) {
        setSize(size, size);
    }

    public void setSize(float width, float height) {
        for (int i = 0; i < animation.getKeyFrames().length; i++) {
            animation.getKeyFrames()[i].setSize(width, height);
        }
    }

    public void enableLooping() {
        animation.setPlayMode(LOOP);
    }

    public void resetTime() {
        time = 0f;
    }
}