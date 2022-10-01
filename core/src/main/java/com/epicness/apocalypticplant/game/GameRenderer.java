package com.epicness.apocalypticplant.game;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.apocalypticplant.game.stuff.GameStuff;
import com.epicness.fundamentals.renderer.Renderer;

import space.earlygrey.shapedrawer.ShapeDrawer;

public class GameRenderer extends Renderer<GameStuff> {

    private final ShapeDrawer shapeDrawer;

    public GameRenderer() {
        TextureRegion pixel = new TextureRegion(new Texture("fundamentals/images/pixel.png"));
        shapeDrawer = new ShapeDrawer(spriteBatch, pixel);
    }

    @Override
    public void render() {
        ScreenUtils.clear(BLACK);

        spriteBatch.begin();
        stuff.getPlant().draw(shapeDrawer);
        for (int i = 0; i < stuff.getLeaves().size; i++) {
            stuff.getLeaves().get(i).draw(spriteBatch);
        }
        stuff.getInstructions().draw(spriteBatch);
        stuff.getScoreText().draw(spriteBatch);
        stuff.getCounter().draw(spriteBatch);
        for (int i = 0; i < stuff.getLives().size; i++) {
            stuff.getLives().get(i).draw(spriteBatch);
        }
        stuff.getResetButton().draw(spriteBatch);
        stuff.getZenButton().draw(spriteBatch);
        for (int i = 0; i < stuff.getFishes().size; i++) {
            stuff.getFishes().get(i).draw(spriteBatch);
        }
        spriteBatch.end();
    }
}