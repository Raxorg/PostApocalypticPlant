package com.epicness.fundamentals.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;
import com.epicness.fundamentals.stuff.interfaces.Scrollable;

public class DualSprited implements Buttonable, Scrollable {

    protected final Sprite background, foreground;

    public DualSprited(Sprite backgroundSprite, Sprite foregroundSprite) {
        background = new Sprite(backgroundSprite);
        foreground = new Sprite(foregroundSprite);
    }

    public void drawBackground(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
    }

    public void drawForeground(SpriteBatch spriteBatch) {
        foreground.draw(spriteBatch);
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        foreground.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return background.getBoundingRectangle().contains(x, y);
    }

    @Override
    public float getY() {
        return background.getY();
    }

    @Override
    public void setY(float y) {
        background.setY(y);
        foreground.setY(y);
    }

    @Override
    public void translateY(float amount) {
        background.translateY(amount);
        foreground.translateY(amount);
    }

    public float getX() {
        return background.getX();
    }

    public void setX(float x) {
        background.setX(x);
        foreground.setX(x);
    }

    public void setPosition(float x, float y) {
        background.setPosition(x, y);
        foreground.setPosition(x, y);
    }

    public void setPosition(Vector2 position) {
        setPosition(position.x, position.y);
    }

    public void setOriginBasedPosition(float x, float y) {
        background.setOriginBasedPosition(x, y);
        foreground.setOriginBasedPosition(x, y);
    }

    public void translateX(float amount) {
        background.translateX(amount);
        foreground.translateX(amount);
    }

    public void setBackgroundSize(float size) {
        background.setSize(size, size);
    }

    public float getWidth() {
        return background.getWidth();
    }

    public float getHeight() {
        return background.getHeight();
    }

    public Vector2 getSize() {
        return new Vector2(getWidth(), getHeight());
    }

    public void setSize(float size) {
        setSize(size, size);
    }

    public void setSize(float width, float height) {
        background.setSize(width, height);
        foreground.setSize(width, height);
    }

    public void rotateBackground(float degrees) {
        background.rotate(degrees);
    }

    public void rotateForeground(float degrees) {
        foreground.rotate(degrees);
    }

    public void rotate(float degrees) {
        rotateBackground(degrees);
        rotateForeground(degrees);
    }

    public Vector2 getScale() {
        return new Vector2(background.getScaleX(), background.getScaleY());
    }

    public void setScale(float scale) {
        background.setScale(scale);
        foreground.setScale(scale);
    }

    public void setOriginCenter() {
        background.setOriginCenter();
        foreground.setOriginCenter();
    }

    public void setBackgroundScale(float scale) {
        background.setScale(scale);
    }

    public void centerBackgroundOrigin() {
        background.setOriginCenter();
    }

    public void setFlip(boolean flipX, boolean flipY) {
        background.setFlip(flipX, flipY);
        foreground.setFlip(flipX, flipY);
    }

    public Color getBackgroundColor() {
        return background.getColor();
    }

    public Color getForegroundColor() {
        return foreground.getColor();
    }

    public void setBackgroundColor(Color color) {
        background.setColor(color);
    }

    public void setForegroundColor(Color color) {
        foreground.setColor(color);
    }

    public void setColor(Color color) {
        setBackgroundColor(color);
        setForegroundColor(color);
    }
}