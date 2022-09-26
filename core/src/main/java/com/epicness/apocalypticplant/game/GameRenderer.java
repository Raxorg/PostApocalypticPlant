package com.epicness.apocalypticplant.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameRenderer extends Renderer<GameStuff> {

    private final ShapeDrawer shapeDrawer;

    public GameRenderer() {
        shapeDrawer = new ShapeDrawer(spriteBatch, new TextureRegion(new Texture("fundamentals/images/pixel.png")));
        shapeDrawer.setDefaultLineWidth(10f);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();
        stuff.getPlant().draw(shapeDrawer);
        for (int i = 0; i < stuff.getLeaves().size; i++) {
            stuff.getLeaves().get(i).draw(spriteBatch);
        }
        stuff.getInstructions().draw(spriteBatch);
        stuff.getCounter().draw(spriteBatch);
        for (int i = 0; i < stuff.getLives().size; i++) {
            stuff.getLives().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getFishes().size; i++) {
            stuff.getFishes().get(i).draw(spriteBatch);
        }
        spriteBatch.end();
    }
}