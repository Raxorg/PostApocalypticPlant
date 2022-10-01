package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.GREEN;
import static com.epicness.fundamentals.SharedConstants.WHITE_CLEAR_25;
import static com.epicness.fundamentals.SharedConstants.WHITE_CLEAR_50;

public class ZenButtonHandler extends GameLogicHandler {

    @Override
    protected void init() {
        darken();
    }

    public void buttonPressed() {
        logic.get(CounterHandler.class).disable();
        logic.get(FishHandler.class).disable();
        logic.get(ScoreHandler.class).disable();
        logic.get(LivesHandler.class).disable();
        logic.get(InstructionsHandler.class).disable();
    }

    private void highlight() {
        stuff.getZenButton().setBackgroundColor(GREEN);
        stuff.getZenButton().setTextColor(GREEN);
    }

    private void darken() {
        stuff.getZenButton().setBackgroundColor(WHITE_CLEAR_50);
        stuff.getZenButton().setTextColor(WHITE_CLEAR_25);
    }

    public void touchDown(float x, float y) {
        if (stuff.getZenButton().contains(x, y)) {
            highlight();
        }
    }

    public void touchDragged(float x, float y) {
        if (stuff.getZenButton().contains(x, y)) {
            highlight();
            return;
        }
        darken();
    }

    public void touchUp(float x, float y) {
        if (stuff.getZenButton().contains(x, y)) {
            buttonPressed();
        }
        darken();
    }
}