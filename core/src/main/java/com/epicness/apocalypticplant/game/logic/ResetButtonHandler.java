package com.epicness.apocalypticplant.game.logic;

import static com.badlogic.gdx.graphics.Color.ORANGE;
import static com.epicness.fundamentals.SharedConstants.WHITE_CLEAR_25;
import static com.epicness.fundamentals.SharedConstants.WHITE_CLEAR_50;

public class ResetButtonHandler extends GameLogicHandler {

    @Override
    protected void init() {
        darken();
    }

    public void buttonPressed() {
        logic.initialLogic();
    }

    private void highlight() {
        stuff.getResetButton().setBackgroundColor(ORANGE);
        stuff.getResetButton().setTextColor(ORANGE);
    }

    private void darken() {
        stuff.getResetButton().setBackgroundColor(WHITE_CLEAR_50);
        stuff.getResetButton().setTextColor(WHITE_CLEAR_25);
    }

    public void touchDown(float x, float y) {
        if (stuff.getResetButton().contains(x, y)) {
            highlight();
        }
    }

    public void touchDragged(float x, float y) {
        if (stuff.getResetButton().contains(x, y)) {
            highlight();
            return;
        }
        darken();
    }

    public void touchUp(float x, float y) {
        if (stuff.getResetButton().contains(x, y)) {
            buttonPressed();
        }
        darken();
    }
}