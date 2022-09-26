package com.epicness.apocalypticplant.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

public class GameRenderer extends Renderer<GameStuff> {

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        spriteBatch.begin();
        for (int i = 0; i < stuff.getLeaves().size; i++) {
            stuff.getLeaves().get(i).draw(spriteBatch);
        }
        spriteBatch.end();
    }
}